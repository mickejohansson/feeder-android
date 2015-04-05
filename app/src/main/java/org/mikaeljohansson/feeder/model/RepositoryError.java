package org.mikaeljohansson.feeder.model;

public class RepositoryError {
    private String mErrorMessage;
    private Exception mException;

    public String getErrorMessage() {
        return mErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        mErrorMessage = errorMessage;
    }

    public Exception getException() {
        return mException;
    }

    public void setException(Exception exception) {
        mException = exception;
    }

}
