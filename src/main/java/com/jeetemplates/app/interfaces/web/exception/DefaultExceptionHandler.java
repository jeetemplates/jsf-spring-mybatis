/**
 *
 */
package com.jeetemplates.app.interfaces.web.exception;

import java.util.Iterator;
import java.util.Map;

import javax.faces.FacesException;
import javax.faces.application.NavigationHandler;
import javax.faces.application.ProjectStage;
import javax.faces.application.ViewExpiredException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;
import javax.servlet.http.HttpSession;

/**
 * Exception Handler
 *
 * @author jeetamplates
 */
public class DefaultExceptionHandler extends ExceptionHandlerWrapper {

    /**
     * key for session scoped message detail
     */
    private static final String ERROR_MESSAGE = "errorMessage";

    /**
     * {@link ExceptionHandler}.
     */
    private ExceptionHandler wrapped;

    /**
     * Constructor.
     *
     * @param wrapped
     */
    public DefaultExceptionHandler(ExceptionHandler wrapped) {
        this.wrapped = wrapped;
    }

    /**
     * @see ExceptionHandlerWrapper#getWrapped()
     */
    @Override
    public ExceptionHandler getWrapped() {
        return this.wrapped;
    }

    /**
     * @see ExceptionHandlerWrapper#handle()
     */
    @Override
    public void handle() throws FacesException {
        FacesContext fc = FacesContext.getCurrentInstance();
        final Map<String, Object> requestMap = fc.getExternalContext().getRequestMap();
        final NavigationHandler nav = fc.getApplication().getNavigationHandler();
        if (fc.isProjectStage(ProjectStage.Development)) {
            // Code for development mode. E.g. let the parent handle exceptions
            getWrapped().handle();
        } else {
            for (Iterator<ExceptionQueuedEvent> i = getUnhandledExceptionQueuedEvents().iterator(); i.hasNext();) {
                ExceptionQueuedEvent event = i.next();
                ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();
                String redirectPage = null;
                Throwable t = context.getException();
                try {
                    if (t instanceof ViewExpiredException) {
                        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
                        if (session != null) {
                            // should not happen
                            session.invalidate();
                        }
                        // redirect to the login page
                        redirectPage = "/faces/home.xhtml?faces-redirect=true";
                    } else {
						// custom handling of unexpected exceptions can be done
                        // in the method handleUnexpected
                        String messageKey = handleUnexpected(fc, t);
                        redirectPage = "/faces/error.xhtml?faces-redirect=true&errorCode=" + messageKey;
                        fc.getExternalContext().getSessionMap().put(DefaultExceptionHandler.ERROR_MESSAGE, t.getLocalizedMessage());
                    }
                } finally {
                    i.remove();
                }
                requestMap.put("exceptionMessage", t.getMessage());
                nav.handleNavigation(fc, null, redirectPage);
                fc.renderResponse();
                break;
            }
        }
    }

    /**
     * Use this method to handle any unexpected exception.
     *
     * @param facesContext : faces context
     * @param t : throwable
     * @return : error code
     */
    protected String handleUnexpected(FacesContext facesContext, final Throwable t) {
        String errorCode = "Exception";
        if (t instanceof FacesException) {
            errorCode = "FacesException";
        }
        return errorCode;
    }
}
