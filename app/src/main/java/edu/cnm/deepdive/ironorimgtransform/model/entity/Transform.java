package edu.cnm.deepdive.ironorimgtransform.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Encapsulates the attributes of a single image transformation algorithm. Room and GSon annotations
 * are used to specify entity &amp; attribute mapping for database persistence, and property mapping
 * for JSON serialization/deserialization mapping.
 */
@Entity

public class Transform {

  @ColumnInfo(name = "transform_id")
  @PrimaryKey(autoGenerate = true)
  private long id;

  @NonNull
  @ColumnInfo(name = "name", index = true)
  private String name = "";

  @ColumnInfo(name = "detail", index = true, collate = ColumnInfo.NOCASE)
  private String detail;// this may become several columns)

  private String example;// this can be a drawable resource or it could be a url.

  private String clazz;


  /**
   * Returns and instance of this String for identifying {@link Transform} entity.
   *
   * @return String value of clazz.
   */
  public String getClazz() {
    return clazz;
  }

  /**
   * Sets the String identifying the {@link Transform} entity.
   *
   */
  public void setClazz(String clazz) {
    this.clazz = clazz;
  }

  /**
   * Returns the autogenerated primary key of this instance.
   *
   * @return primary key value.
   */
  public long getId() {
    return id;
  }

  /**
   * Sets the primary key of this instance. This method is invoked by Room to set the autogenerated
   * value of a new instance, and when loading an existing instance from the database.
   *
   * @param id primary key value.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Returns the name of this instance.
   *
   * @return Transform name.
   */
  @NonNull
  public String getName() {
    return name;
  }

  /**
   * Sets the name of this instance. This method is invoked by Room and GSon after loading from the
   * database and JSON deserialization, respectively.
   *
   * @param name Transform name.
   */
  public void setName(@NonNull String name) {
    this.name = name;
  }

  /**
   * Returns the details (descriptive information) of this instance.
   *
   * @return Transform explanation.
   */
  public String getDetail() {
    return detail;
  }

  /**
   * Sets the details (descriptive details) of this instance. This method is invoked by Room
   * and GSon after loading from the database and JSON deserialization, respectively.
   *
   * @param detail Transform explanation (descriptive information).
   */
  public void setDetail(String detail) {
    this.detail = detail;
  }

  /**
   * Returns url to example of transformed image
   * @return url to example image.
   */
  public String getExample() {
    return example;
  }

  /**
   * Sets the url of example image.
   * @param example example image url.
   */
  public void setExample(String example) {
    this.example = example;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Transform transform = (Transform) o;

    if (!name.equals(transform.name)) {
      return false;
    }
    if (detail != null ? !detail.equals(transform.detail) : transform.detail != null) {
      return false;
    }
    if (example != null ? !example.equals(transform.example) : transform.example != null) {
      return false;
    }
    return clazz != null ? clazz.equals(transform.clazz) : transform.clazz == null;
  }

  @Override
  public int hashCode() {
    int result = name.hashCode();
    result = 31 * result + (detail != null ? detail.hashCode() : 0);
    result = 31 * result + (example != null ? example.hashCode() : 0);
    result = 31 * result + (clazz != null ? clazz.hashCode() : 0);
    return result;
  }
}
