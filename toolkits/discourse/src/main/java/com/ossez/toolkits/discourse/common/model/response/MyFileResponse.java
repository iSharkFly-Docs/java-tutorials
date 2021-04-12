package discourse.common.model.response;

import java.io.Serializable;

/**
 * MyFileResponse for API my file response
 *
 * @author YuCheng Hu
 */
public class MyFileResponse implements Serializable {
    private static final long serialVersionUID = -5103349220463423614L;

    private Long id;
    private String azureInputFileUUID;
    private String azureInputFileETag;
    private String azureOutputFileUUID;
    private String azureOutputFileETag;
    private String customerName;
    private String inputFileName;
    private Integer fileCountRow;
    private Integer fileCountAliasMatch;
    private Integer fileCountDirectMatch;
    private Integer fileCountNoMatch;
    private String dateCreated;
    private String uuid;

    public String getAzureInputFileUUID() {
        return azureInputFileUUID;
    }

    public void setAzureInputFileUUID(String azureInputFileUUID) {
        this.azureInputFileUUID = azureInputFileUUID;
    }

    public String getAzureInputFileETag() {
        return azureInputFileETag;
    }

    public void setAzureInputFileETag(String azureInputFileETag) {
        this.azureInputFileETag = azureInputFileETag;
    }

    public String getAzureOutputFileUUID() {
        return azureOutputFileUUID;
    }

    public void setAzureOutputFileUUID(String azureOutputFileUUID) {
        this.azureOutputFileUUID = azureOutputFileUUID;
    }

    public String getAzureOutputFileETag() {
        return azureOutputFileETag;
    }

    public void setAzureOutputFileETag(String azureOutputFileETag) {
        this.azureOutputFileETag = azureOutputFileETag;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getInputFileName() {
        return inputFileName;
    }

    public void setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFileCountRow() {
        return fileCountRow;
    }

    public void setFileCountRow(Integer fileCountRow) {
        this.fileCountRow = fileCountRow;
    }

    public Integer getFileCountAliasMatch() {
        return fileCountAliasMatch;
    }

    public void setFileCountAliasMatch(Integer fileCountAliasMatch) {
        this.fileCountAliasMatch = fileCountAliasMatch;
    }

    public Integer getFileCountDirectMatch() {
        return fileCountDirectMatch;
    }

    public void setFileCountDirectMatch(Integer fileCountDirectMatch) {
        this.fileCountDirectMatch = fileCountDirectMatch;
    }

    public Integer getFileCountNoMatch() {
        return fileCountNoMatch;
    }

    public void setFileCountNoMatch(Integer fileCountNoMatch) {
        this.fileCountNoMatch = fileCountNoMatch;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
