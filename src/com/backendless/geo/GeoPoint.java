/*
 * ********************************************************************************************************************
 *  <p/>
 *  BACKENDLESS.COM CONFIDENTIAL
 *  <p/>
 *  ********************************************************************************************************************
 *  <p/>
 *  Copyright 2012 BACKENDLESS.COM. All Rights Reserved.
 *  <p/>
 *  NOTICE: All information contained herein is, and remains the property of Backendless.com and its suppliers,
 *  if any. The intellectual and technical concepts contained herein are proprietary to Backendless.com and its
 *  suppliers and may be covered by U.S. and Foreign Patents, patents in process, and are protected by trade secret
 *  or copyright law. Dissemination of this information or reproduction of this material is strictly forbidden
 *  unless prior written permission is obtained from Backendless.com.
 *  <p/>
 *  ********************************************************************************************************************
 */

package com.backendless.geo;

import com.backendless.commons.geo.BaseGeoPoint;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GeoPoint extends BaseGeoPoint implements Serializable
{
  private static final long serialVersionUID = -4982310969493523406L;
  private final static int multiplier = 1000000;

  public GeoPoint()
  {
  }

  public GeoPoint( double latitude, double longitude )
  {
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public GeoPoint( int latitudeE6, int longitudeE6 )
  {
    this.latitude = (double) latitudeE6 / multiplier;
    this.longitude = (double) longitudeE6 / multiplier;
  }

  public GeoPoint( double latitude, double longitude, List<String> categories, Map<String, String> metadata )
  {
    this.latitude = latitude;
    this.longitude = longitude;
    this.categories = categories;
    this.setMetadata( metadata );
  }

  public GeoPoint( int latitudeE6, int longitudeE6, List<String> categories, Map<String, String> metadata )
  {
    this.latitude = (double) latitudeE6 / multiplier;
    this.longitude = (double) longitudeE6 / multiplier;
    this.categories = categories;
    this.setMetadata( metadata );
  }

  public int getLatitudeE6()
  {
    return (int) (latitude * multiplier);
  }

  public void setLatitudeE6( int latitudeE6 )
  {
    this.latitude = (double) latitudeE6 / multiplier;
  }

  public int getLongitudeE6()
  {
    return (int) (longitude * multiplier);
  }

  public void setLongitudeE6( int longitudeE6 )
  {
    this.longitude = (double) longitudeE6 / multiplier;
  }

  public List<String> getCategories()
  {
    if( categories == null )
      return categories = new ArrayList<String>();

    return new ArrayList<String>( categories );
  }

  public void addCategory( String category )
  {
    if( categories == null )
      categories = new ArrayList<String>();

    categories.add( category );
  }

  public String getMetadata( String key )
  {
    if( objectMetadata == null )
      return null;

    return (String) objectMetadata.get( key );
  }

  public void putMetadata( String key, String value )
  {
    addMetadata( key, value );
  }

  public void putAllMetadata( Map<String, String> metadata )
  {
    super.setMetadata( metadata );
  }

  public void clearMetadata()
  {
    if( this.objectMetadata != null )
      objectMetadata.clear();
  }

  public void setCategories( List<String> categories )
  {
    this.categories = categories;
  }

  public Double getDistance()
  {
    return distance;
  }

  public void setDistance( Double distance )
  {
    this.distance = distance;
  }

  @Override
  public boolean equals( Object o )
  {
    if( this == o )
    {
      return true;
    }
    if( o == null || this.getClass() != o.getClass() )
    {
      return false;
    }

    GeoPoint geoPoint = (GeoPoint) o;

    if( Double.compare( geoPoint.latitude, latitude ) != 0 )
    {
      return false;
    }
    if( Double.compare( geoPoint.longitude, longitude ) != 0 )
    {
      return false;
    }
    if( categories != null ? !categories.equals( geoPoint.categories ) : geoPoint.categories != null )
    {
      return false;
    }
    if( distance != null ? !distance.equals( geoPoint.distance ) : geoPoint.distance != null )
    {
      return false;
    }
    if( objectMetadata != null ? !objectMetadata.equals( geoPoint.objectMetadata ) : geoPoint.objectMetadata != null )
    {
      return false;
    }
    if( objectId != null ? !objectId.equals( geoPoint.objectId ) : geoPoint.objectId != null )
    {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode()
  {
    int result;
    long temp;
    result = objectId != null ? objectId.hashCode() : 0;
    temp = Double.doubleToLongBits( latitude );
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits( longitude );
    result = 31 * result + (int) (temp ^ (temp >>> 32));
    result = 31 * result + (categories != null ? categories.hashCode() : 0);
    result = 31 * result + (objectMetadata != null ? objectMetadata.hashCode() : 0);
    result = 31 * result + (distance != null ? distance.hashCode() : 0);
    return result;
  }

  @Override
  public String toString()
  {
    final StringBuilder sb = new StringBuilder( "GeoPoint{" );
    sb.append( "objectId='" ).append( objectId ).append( '\'' );
    sb.append( ", latitude=" ).append( latitude );
    sb.append( ", longitude=" ).append( longitude );
    sb.append( ", categories=" ).append( categories );
    sb.append( ", metadata=" ).append( objectMetadata );
    sb.append( ", distance=" ).append( distance );
    sb.append( '}' );
    return sb.toString();
  }
}