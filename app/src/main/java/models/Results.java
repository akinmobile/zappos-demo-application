package models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Akinsete on 2/11/17.
 */
public class Results
{
    @SerializedName("brandName")
    String brandName;
    @SerializedName("thumbnailImageUrl")
    String thumbnailImageUrl;
    @SerializedName("productId")
    String productId;
    @SerializedName("originalPrice")
    String  originalPrice;
    @SerializedName("styleId")
    String  styleId;
    @SerializedName("colorId")
    String  colorId;
    @SerializedName("price")
    String  price;
    @SerializedName("percentOff")
    String  percentOff;
    @SerializedName("productUrl")
    String  productUrl;
    @SerializedName("productName")
    String  productName;

    public String getStyleId ()
    {
        return styleId;
    }

    public void setStyleId (String styleId)
    {
        this.styleId = styleId;
    }

    public String getPrice ()
    {
        return price;
    }

    public void setPrice (String price)
    {
        this.price = price;
    }

    public String getOriginalPrice ()
    {
        return originalPrice;
    }

    public void setOriginalPrice (String originalPrice)
    {
        this.originalPrice = originalPrice;
    }

    public String getProductUrl ()
    {
        return productUrl;
    }

    public void setProductUrl (String productUrl)
    {
        this.productUrl = productUrl;
    }

    public String getColorId ()
    {
        return colorId;
    }

    public void setColorId (String colorId)
    {
        this.colorId = colorId;
    }

    public String getProductName ()
    {
        return productName;
    }

    public void setProductName (String productName)
    {
        this.productName = productName;
    }

    public String getBrandName ()
    {
        return brandName;
    }

    public void setBrandName (String brandName)
    {
        this.brandName = brandName;
    }

    public String getThumbnailImageUrl ()
    {
        return thumbnailImageUrl;
    }

    public void setThumbnailImageUrl (String thumbnailImageUrl)
    {
        this.thumbnailImageUrl = thumbnailImageUrl;
    }

    public String getPercentOff ()
    {
        return percentOff;
    }

    public void setPercentOff (String percentOff)
    {
        this.percentOff = percentOff;
    }

    public String getProductId ()
    {
        return productId;
    }

    public void setProductId (String productId)
    {
        this.productId = productId;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [styleId = "+styleId+", price = "+price+", originalPrice = "+originalPrice+", productUrl = "+productUrl+", colorId = "+colorId+", productName = "+productName+", brandName = "+brandName+", thumbnailImageUrl = "+thumbnailImageUrl+", percentOff = "+percentOff+", productId = "+productId+"]";
    }
}
