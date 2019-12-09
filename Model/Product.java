package Model;

import java.util.*;

public class Product extends ItemDescriptor
{
    private int categoryID;
    private int minStock;
    private int maxStock;
    private double recommendedRetailPrice;
    private double tradeAllowance;
    private double costPrice;
    private double sellingPrice;
    private boolean isUnique;
    private LocationLine atDIY;
    private LocationLine atTimber;
    private Stack<Copy> copies = new Stack<Copy>();
    
    public Product(String barcode, String name, int id, int min, int max, double rec, double trade, double cost, double sell)
    {
        super(barcode, name);
        categoryID = id;
        minStock = min;
        maxStock = max;
        recommendedRetailPrice = rec;
        tradeAllowance = trade;
        costPrice = cost;
        sellingPrice = sell;
        isUnique = false;
    }
    
    public int getCategoryID()
    {
        return categoryID;
    }
    public int getMinStock()
    {
        return minStock;
    }
    public int getMaxStock()
    {
        return maxStock;
    }
    public double getRecommendedRetailPrice()
    {
        return recommendedRetailPrice;
    }
    public double getTradeAllowance()
    {
        return tradeAllowance;
    }
    public double getCostPrice()
    {
        return costPrice;
    }
    public boolean isUnique()
    {
        return isUnique;
    }
    public void setCategoryID(int categoryID)
    {
        this.categoryID = categoryID;
    } 
    public void setMinStock(int minStock)
    {
        this.minStock = minStock;
    } 
    public void setMaxStock(int maxStock)
    {
        this.maxStock = maxStock;
    } 
    public void setRecommendedRetailPrice(double recommendedRetailPrice)
    {
        this.recommendedRetailPrice = recommendedRetailPrice;
    } 
    public void setTradeAllowance(double tradeAllowance)
    {
        this.tradeAllowance = tradeAllowance;
    } 
    public void setCostPrice(double costPrice)
    {
        this.costPrice = costPrice;
    }
    public void makeUnique()
    {
        this.isUnique = true;
    }
    public void setInStockAtDIY(int inStockAtDIY)
    {
        this.atDIY.setQuantity(inStockAtDIY);
    }
    public void setInStockAtTimber(int inStockAtTimber)
    {
        this.atTimber.setQuantity(inStockAtTimber);
    }
    
    public void setDIY(LocationLine locationLine)
    {
        this.atDIY = locationLine;
    }
    
    public void setimber(LocationLine locationLine)
    {
        this.atTimber = locationLine;
    }
    
    
    public double getSellingPrice()
    {
        return sellingPrice;
    }
    public void setSellingPrice(double sellingPrice)
    {
        this.sellingPrice = sellingPrice;
    }
    public Copy getCopy()
    {
    	Copy c = null;
    	if(!copies.isEmpty()) {
    		c = copies.pop();
    	}
    	return c;
    }
    
    public void addCopy(Copy copy)
    {
    	if(!isUnique) {
    		copies.push(copy);
    	}
    }    
}

