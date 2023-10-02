/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.github.zacharydhamilton.events.vehicles;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class Car extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -5619312434384781018L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Car\",\"namespace\":\"com.github.zacharydhamilton.events.vehicles\",\"fields\":[{\"name\":\"wheels\",\"type\":\"int\",\"doc\":\"The number of wheels this vehicle has\"},{\"name\":\"make\",\"type\":\"string\",\"doc\":\"The make of the vehicle\"},{\"name\":\"model\",\"type\":\"string\",\"doc\":\"The model of the vehicle\"},{\"name\":\"sport\",\"type\":\"boolean\",\"doc\":\"Whether or not this vehicle is a sport\"},{\"name\":\"spoiler\",\"type\":\"boolean\",\"doc\":\"Whether or not this vehicle has a spoiler\"}],\"version\":\"1\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Car> ENCODER =
      new BinaryMessageEncoder<Car>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Car> DECODER =
      new BinaryMessageDecoder<Car>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Car> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Car> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Car> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Car>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Car to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Car from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Car instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Car fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** The number of wheels this vehicle has */
  private int wheels;
  /** The make of the vehicle */
  private java.lang.CharSequence make;
  /** The model of the vehicle */
  private java.lang.CharSequence model;
  /** Whether or not this vehicle is a sport */
  private boolean sport;
  /** Whether or not this vehicle has a spoiler */
  private boolean spoiler;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Car() {}

  /**
   * All-args constructor.
   * @param wheels The number of wheels this vehicle has
   * @param make The make of the vehicle
   * @param model The model of the vehicle
   * @param sport Whether or not this vehicle is a sport
   * @param spoiler Whether or not this vehicle has a spoiler
   */
  public Car(java.lang.Integer wheels, java.lang.CharSequence make, java.lang.CharSequence model, java.lang.Boolean sport, java.lang.Boolean spoiler) {
    this.wheels = wheels;
    this.make = make;
    this.model = model;
    this.sport = sport;
    this.spoiler = spoiler;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return wheels;
    case 1: return make;
    case 2: return model;
    case 3: return sport;
    case 4: return spoiler;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: wheels = (java.lang.Integer)value$; break;
    case 1: make = (java.lang.CharSequence)value$; break;
    case 2: model = (java.lang.CharSequence)value$; break;
    case 3: sport = (java.lang.Boolean)value$; break;
    case 4: spoiler = (java.lang.Boolean)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'wheels' field.
   * @return The number of wheels this vehicle has
   */
  public int getWheels() {
    return wheels;
  }


  /**
   * Sets the value of the 'wheels' field.
   * The number of wheels this vehicle has
   * @param value the value to set.
   */
  public void setWheels(int value) {
    this.wheels = value;
  }

  /**
   * Gets the value of the 'make' field.
   * @return The make of the vehicle
   */
  public java.lang.CharSequence getMake() {
    return make;
  }


  /**
   * Sets the value of the 'make' field.
   * The make of the vehicle
   * @param value the value to set.
   */
  public void setMake(java.lang.CharSequence value) {
    this.make = value;
  }

  /**
   * Gets the value of the 'model' field.
   * @return The model of the vehicle
   */
  public java.lang.CharSequence getModel() {
    return model;
  }


  /**
   * Sets the value of the 'model' field.
   * The model of the vehicle
   * @param value the value to set.
   */
  public void setModel(java.lang.CharSequence value) {
    this.model = value;
  }

  /**
   * Gets the value of the 'sport' field.
   * @return Whether or not this vehicle is a sport
   */
  public boolean getSport() {
    return sport;
  }


  /**
   * Sets the value of the 'sport' field.
   * Whether or not this vehicle is a sport
   * @param value the value to set.
   */
  public void setSport(boolean value) {
    this.sport = value;
  }

  /**
   * Gets the value of the 'spoiler' field.
   * @return Whether or not this vehicle has a spoiler
   */
  public boolean getSpoiler() {
    return spoiler;
  }


  /**
   * Sets the value of the 'spoiler' field.
   * Whether or not this vehicle has a spoiler
   * @param value the value to set.
   */
  public void setSpoiler(boolean value) {
    this.spoiler = value;
  }

  /**
   * Creates a new Car RecordBuilder.
   * @return A new Car RecordBuilder
   */
  public static com.github.zacharydhamilton.events.vehicles.Car.Builder newBuilder() {
    return new com.github.zacharydhamilton.events.vehicles.Car.Builder();
  }

  /**
   * Creates a new Car RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Car RecordBuilder
   */
  public static com.github.zacharydhamilton.events.vehicles.Car.Builder newBuilder(com.github.zacharydhamilton.events.vehicles.Car.Builder other) {
    if (other == null) {
      return new com.github.zacharydhamilton.events.vehicles.Car.Builder();
    } else {
      return new com.github.zacharydhamilton.events.vehicles.Car.Builder(other);
    }
  }

  /**
   * Creates a new Car RecordBuilder by copying an existing Car instance.
   * @param other The existing instance to copy.
   * @return A new Car RecordBuilder
   */
  public static com.github.zacharydhamilton.events.vehicles.Car.Builder newBuilder(com.github.zacharydhamilton.events.vehicles.Car other) {
    if (other == null) {
      return new com.github.zacharydhamilton.events.vehicles.Car.Builder();
    } else {
      return new com.github.zacharydhamilton.events.vehicles.Car.Builder(other);
    }
  }

  /**
   * RecordBuilder for Car instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Car>
    implements org.apache.avro.data.RecordBuilder<Car> {

    /** The number of wheels this vehicle has */
    private int wheels;
    /** The make of the vehicle */
    private java.lang.CharSequence make;
    /** The model of the vehicle */
    private java.lang.CharSequence model;
    /** Whether or not this vehicle is a sport */
    private boolean sport;
    /** Whether or not this vehicle has a spoiler */
    private boolean spoiler;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.github.zacharydhamilton.events.vehicles.Car.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.wheels)) {
        this.wheels = data().deepCopy(fields()[0].schema(), other.wheels);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.make)) {
        this.make = data().deepCopy(fields()[1].schema(), other.make);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.model)) {
        this.model = data().deepCopy(fields()[2].schema(), other.model);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.sport)) {
        this.sport = data().deepCopy(fields()[3].schema(), other.sport);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.spoiler)) {
        this.spoiler = data().deepCopy(fields()[4].schema(), other.spoiler);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
    }

    /**
     * Creates a Builder by copying an existing Car instance
     * @param other The existing instance to copy.
     */
    private Builder(com.github.zacharydhamilton.events.vehicles.Car other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.wheels)) {
        this.wheels = data().deepCopy(fields()[0].schema(), other.wheels);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.make)) {
        this.make = data().deepCopy(fields()[1].schema(), other.make);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.model)) {
        this.model = data().deepCopy(fields()[2].schema(), other.model);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.sport)) {
        this.sport = data().deepCopy(fields()[3].schema(), other.sport);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.spoiler)) {
        this.spoiler = data().deepCopy(fields()[4].schema(), other.spoiler);
        fieldSetFlags()[4] = true;
      }
    }

    /**
      * Gets the value of the 'wheels' field.
      * The number of wheels this vehicle has
      * @return The value.
      */
    public int getWheels() {
      return wheels;
    }


    /**
      * Sets the value of the 'wheels' field.
      * The number of wheels this vehicle has
      * @param value The value of 'wheels'.
      * @return This builder.
      */
    public com.github.zacharydhamilton.events.vehicles.Car.Builder setWheels(int value) {
      validate(fields()[0], value);
      this.wheels = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'wheels' field has been set.
      * The number of wheels this vehicle has
      * @return True if the 'wheels' field has been set, false otherwise.
      */
    public boolean hasWheels() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'wheels' field.
      * The number of wheels this vehicle has
      * @return This builder.
      */
    public com.github.zacharydhamilton.events.vehicles.Car.Builder clearWheels() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'make' field.
      * The make of the vehicle
      * @return The value.
      */
    public java.lang.CharSequence getMake() {
      return make;
    }


    /**
      * Sets the value of the 'make' field.
      * The make of the vehicle
      * @param value The value of 'make'.
      * @return This builder.
      */
    public com.github.zacharydhamilton.events.vehicles.Car.Builder setMake(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.make = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'make' field has been set.
      * The make of the vehicle
      * @return True if the 'make' field has been set, false otherwise.
      */
    public boolean hasMake() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'make' field.
      * The make of the vehicle
      * @return This builder.
      */
    public com.github.zacharydhamilton.events.vehicles.Car.Builder clearMake() {
      make = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'model' field.
      * The model of the vehicle
      * @return The value.
      */
    public java.lang.CharSequence getModel() {
      return model;
    }


    /**
      * Sets the value of the 'model' field.
      * The model of the vehicle
      * @param value The value of 'model'.
      * @return This builder.
      */
    public com.github.zacharydhamilton.events.vehicles.Car.Builder setModel(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.model = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'model' field has been set.
      * The model of the vehicle
      * @return True if the 'model' field has been set, false otherwise.
      */
    public boolean hasModel() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'model' field.
      * The model of the vehicle
      * @return This builder.
      */
    public com.github.zacharydhamilton.events.vehicles.Car.Builder clearModel() {
      model = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'sport' field.
      * Whether or not this vehicle is a sport
      * @return The value.
      */
    public boolean getSport() {
      return sport;
    }


    /**
      * Sets the value of the 'sport' field.
      * Whether or not this vehicle is a sport
      * @param value The value of 'sport'.
      * @return This builder.
      */
    public com.github.zacharydhamilton.events.vehicles.Car.Builder setSport(boolean value) {
      validate(fields()[3], value);
      this.sport = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'sport' field has been set.
      * Whether or not this vehicle is a sport
      * @return True if the 'sport' field has been set, false otherwise.
      */
    public boolean hasSport() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'sport' field.
      * Whether or not this vehicle is a sport
      * @return This builder.
      */
    public com.github.zacharydhamilton.events.vehicles.Car.Builder clearSport() {
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'spoiler' field.
      * Whether or not this vehicle has a spoiler
      * @return The value.
      */
    public boolean getSpoiler() {
      return spoiler;
    }


    /**
      * Sets the value of the 'spoiler' field.
      * Whether or not this vehicle has a spoiler
      * @param value The value of 'spoiler'.
      * @return This builder.
      */
    public com.github.zacharydhamilton.events.vehicles.Car.Builder setSpoiler(boolean value) {
      validate(fields()[4], value);
      this.spoiler = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'spoiler' field has been set.
      * Whether or not this vehicle has a spoiler
      * @return True if the 'spoiler' field has been set, false otherwise.
      */
    public boolean hasSpoiler() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'spoiler' field.
      * Whether or not this vehicle has a spoiler
      * @return This builder.
      */
    public com.github.zacharydhamilton.events.vehicles.Car.Builder clearSpoiler() {
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Car build() {
      try {
        Car record = new Car();
        record.wheels = fieldSetFlags()[0] ? this.wheels : (java.lang.Integer) defaultValue(fields()[0]);
        record.make = fieldSetFlags()[1] ? this.make : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.model = fieldSetFlags()[2] ? this.model : (java.lang.CharSequence) defaultValue(fields()[2]);
        record.sport = fieldSetFlags()[3] ? this.sport : (java.lang.Boolean) defaultValue(fields()[3]);
        record.spoiler = fieldSetFlags()[4] ? this.spoiler : (java.lang.Boolean) defaultValue(fields()[4]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Car>
    WRITER$ = (org.apache.avro.io.DatumWriter<Car>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Car>
    READER$ = (org.apache.avro.io.DatumReader<Car>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeInt(this.wheels);

    out.writeString(this.make);

    out.writeString(this.model);

    out.writeBoolean(this.sport);

    out.writeBoolean(this.spoiler);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.wheels = in.readInt();

      this.make = in.readString(this.make instanceof Utf8 ? (Utf8)this.make : null);

      this.model = in.readString(this.model instanceof Utf8 ? (Utf8)this.model : null);

      this.sport = in.readBoolean();

      this.spoiler = in.readBoolean();

    } else {
      for (int i = 0; i < 5; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.wheels = in.readInt();
          break;

        case 1:
          this.make = in.readString(this.make instanceof Utf8 ? (Utf8)this.make : null);
          break;

        case 2:
          this.model = in.readString(this.model instanceof Utf8 ? (Utf8)this.model : null);
          break;

        case 3:
          this.sport = in.readBoolean();
          break;

        case 4:
          this.spoiler = in.readBoolean();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}









