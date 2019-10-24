package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【其他设置】对象 sys_other_set
 * 
 * @author ruoyi
 * @date 2019-10-12
 */
public class SysOtherSet extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${siteName}", readConverterExp = "$column.readConverterExp()")
    private String siteName;

    /** $column.columnComment */
    @Excel(name = "${websiteDomain}", readConverterExp = "$column.readConverterExp()")
    private String websiteDomain;

    /** $column.columnComment */
    @Excel(name = "${homeTitle}", readConverterExp = "$column.readConverterExp()")
    private String homeTitle;

    /** $column.columnComment */
    @Excel(name = "${metaKey}", readConverterExp = "$column.readConverterExp()")
    private String metaKey;

    /** $column.columnComment */
    @Excel(name = "${metaDescri}", readConverterExp = "$column.readConverterExp()")
    private String metaDescri;

    /** $column.columnComment */
    @Excel(name = "${copyRightInfo}", readConverterExp = "$column.readConverterExp()")
    private String copyRightInfo;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSiteName(String siteName) 
    {
        this.siteName = siteName;
    }

    public String getSiteName() 
    {
        return siteName;
    }
    public void setWebsiteDomain(String websiteDomain) 
    {
        this.websiteDomain = websiteDomain;
    }

    public String getWebsiteDomain() 
    {
        return websiteDomain;
    }
    public void setHomeTitle(String homeTitle) 
    {
        this.homeTitle = homeTitle;
    }

    public String getHomeTitle() 
    {
        return homeTitle;
    }
    public void setMetaKey(String metaKey) 
    {
        this.metaKey = metaKey;
    }

    public String getMetaKey() 
    {
        return metaKey;
    }
    public void setMetaDescri(String metaDescri) 
    {
        this.metaDescri = metaDescri;
    }

    public String getMetaDescri() 
    {
        return metaDescri;
    }
    public void setCopyRightInfo(String copyRightInfo) 
    {
        this.copyRightInfo = copyRightInfo;
    }

    public String getCopyRightInfo() 
    {
        return copyRightInfo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("siteName", getSiteName())
            .append("websiteDomain", getWebsiteDomain())
            .append("homeTitle", getHomeTitle())
            .append("metaKey", getMetaKey())
            .append("metaDescri", getMetaDescri())
            .append("copyRightInfo", getCopyRightInfo())
            .toString();
    }
}
