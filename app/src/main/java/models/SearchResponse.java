package models;

/**
 * Created by Akinsete on 2/11/17.
 */

public class SearchResponse
{
    private String statusCode;

    private Results[] results;

    private String term;

    private String originalTerm;

    private String currentResultCount;

    private String totalResultCount;

    public String getStatusCode ()
    {
        return statusCode;
    }

    public void setStatusCode (String statusCode)
    {
        this.statusCode = statusCode;
    }

    public Results[] getResults ()
    {
        return results;
    }

    public void setResults (Results[] results)
    {
        this.results = results;
    }

    public String getTerm ()
    {
        return term;
    }

    public void setTerm (String term)
    {
        this.term = term;
    }

    public String getOriginalTerm ()
    {
        return originalTerm;
    }

    public void setOriginalTerm (String originalTerm)
    {
        this.originalTerm = originalTerm;
    }

    public String getCurrentResultCount ()
    {
        return currentResultCount;
    }

    public void setCurrentResultCount (String currentResultCount)
    {
        this.currentResultCount = currentResultCount;
    }

    public String getTotalResultCount ()
    {
        return totalResultCount;
    }

    public void setTotalResultCount (String totalResultCount)
    {
        this.totalResultCount = totalResultCount;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [statusCode = "+statusCode+", results = "+results+", term = "+term+", originalTerm = "+originalTerm+", currentResultCount = "+currentResultCount+", totalResultCount = "+totalResultCount+"]";
    }
}
