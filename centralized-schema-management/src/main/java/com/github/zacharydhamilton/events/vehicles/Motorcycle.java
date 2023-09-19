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
public class Motorcycle extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -2932996000050845645L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Motorcycle\",\"namespace\":\"com.github.zacharydhamilton.events.vehicles\",\"fields\":[{\"name\":\"wheels\",\"type\":\"int\",\"doc\":\"The number of wheels this vehicle has\"},{\"name\":\"make\",\"type\":\"string\",\"doc\":\"The make of the vehicle\"},{\"name\":\"model\",\"type\":\"string\",\"doc\":\"The model of the vehicle\"}],\"version\":\"1\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Motorcycle> ENCODER =
      new BinaryMessageEncoder<Motorcycle>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Motorcycle> DECODER =
      new BinaryMessageDecoder<Motorcycle>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Motorcycle> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Motorcycle> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Motorcycle> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Motorcycle>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Motorcycle to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Motorcycle from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Motorcycle instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Motorcycle fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** The number of wheels this vehicle has */
  private int wheels;
  /** The make of the vehicle */
  private java.lang.CharSequence make;
  /** The model of the vehicle */
  private java.lang.CharSequence model;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Motorcycle() {}

  /**
   * All-args constructor.
   * @param wheels The number of wheels this vehicle has
   * @param make The make of the vehicle
   * @param model The model of the vehicle
   */
  public Motorcycle(java.lang.Integer wheels, java.lang.CharSequence make, java.lang.CharSequence model) {
    this.wheels = wheels;
    this.make = make;
    this.model = model;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return wheels;
    case 1: return make;
    case 2: return model;
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
   * Creates a new Motorcycle RecordBuilder.
   * @return A new Motorcycle RecordBuilder
   */
  public static com.github.zacharydhamilton.events.vehicles.Motorcycle.Builder newBuilder() {
    return new com.github.zacharydhamilton.events.vehicles.Motorcycle.Builder();
  }

  /**
   * Creates a new Motorcycle RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Motorcycle RecordBuilder
   */
  public static com.github.zacharydhamilton.events.vehicles.Motorcycle.Builder newBuilder(com.github.zacharydhamilton.events.vehicles.Motorcycle.Builder other) {
    if (other == null) {
      return new com.github.zacharydhamilton.events.vehicles.Motorcycle.Builder();
    } else {
      return new com.github.zacharydhamilton.events.vehicles.Motorcycle.Builder(other);
    }
  }

  /**
   * Creates a new Motorcycle RecordBuilder by copying an existing Motorcycle instance.
   * @param other The existing instance to copy.
   * @return A new Motorcycle RecordBuilder
   */
  public static com.github.zacharydhamilton.events.vehicles.Motorcycle.Builder newBuilder(com.github.zacharydhamilton.events.vehicles.Motorcycle other) {
    if (other == null) {
      return new com.github.zacharydhamilton.events.vehicles.Motorcycle.Builder();
    } else {
      return new com.github.zacharydhamilton.events.vehicles.Motorcycle.Builder(other);
    }
  }

  /**
   * RecordBuilder for Motorcycle instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Motorcycle>
    implements org.apache.avro.data.RecordBuilder<Motorcycle> {

    /** The number of wheels this vehicle has */
    private int wheels;
    /** The make of the vehicle */
    private java.lang.CharSequence make;
    /** The model of the vehicle */
    private java.lang.CharSequence model;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.github.zacharydhamilton.events.vehicles.Motorcycle.Builder other) {
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
    }

    /**
     * Creates a Builder by copying an existing Motorcycle instance
     * @param other The existing instance to copy.
     */
    private Builder(com.github.zacharydhamilton.events.vehicles.Motorcycle other) {
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
    public com.github.zacharydhamilton.events.vehicles.Motorcycle.Builder setWheels(int value) {
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
    public com.github.zacharydhamilton.events.vehicles.Motorcycle.Builder clearWheels() {
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
    public com.github.zacharydhamilton.events.vehicles.Motorcycle.Builder setMake(java.lang.CharSequence value) {
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
    public com.github.zacharydhamilton.events.vehicles.Motorcycle.Builder clearMake() {
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
    public com.github.zacharydhamilton.events.vehicles.Motorcycle.Builder setModel(java.lang.CharSequence value) {
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
    public com.github.zacharydhamilton.events.vehicles.Motorcycle.Builder clearModel() {
      model = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Motorcycle build() {
      try {
        Motorcycle record = new Motorcycle();
        record.wheels = fieldSetFlags()[0] ? this.wheels : (java.lang.Integer) defaultValue(fields()[0]);
        record.make = fieldSetFlags()[1] ? this.make : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.model = fieldSetFlags()[2] ? this.model : (java.lang.CharSequence) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Motorcycle>
    WRITER$ = (org.apache.avro.io.DatumWriter<Motorcycle>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Motorcycle>
    READER$ = (org.apache.avro.io.DatumReader<Motorcycle>)MODEL$.createDatumReader(SCHEMA$);

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

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.wheels = in.readInt();

      this.make = in.readString(this.make instanceof Utf8 ? (Utf8)this.make : null);

      this.model = in.readString(this.model instanceof Utf8 ? (Utf8)this.model : null);

    } else {
      for (int i = 0; i < 3; i++) {
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

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










