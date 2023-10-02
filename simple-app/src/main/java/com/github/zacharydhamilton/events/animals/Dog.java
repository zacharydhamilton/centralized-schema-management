/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.github.zacharydhamilton.events.animals;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class Dog extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -9154497700161456804L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Dog\",\"namespace\":\"com.github.zacharydhamilton.events.animals\",\"fields\":[{\"name\":\"species\",\"type\":\"string\",\"doc\":\"What species the dog this is\"},{\"name\":\"color\",\"type\":\"string\",\"doc\":\"What color the dog is\"},{\"name\":\"name\",\"type\":\"string\",\"doc\":\"The name of the dog\"}],\"version\":\"1\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Dog> ENCODER =
      new BinaryMessageEncoder<Dog>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Dog> DECODER =
      new BinaryMessageDecoder<Dog>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Dog> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Dog> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Dog> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Dog>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Dog to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Dog from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Dog instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Dog fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  /** What species the dog this is */
  private java.lang.CharSequence species;
  /** What color the dog is */
  private java.lang.CharSequence color;
  /** The name of the dog */
  private java.lang.CharSequence name;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Dog() {}

  /**
   * All-args constructor.
   * @param species What species the dog this is
   * @param color What color the dog is
   * @param name The name of the dog
   */
  public Dog(java.lang.CharSequence species, java.lang.CharSequence color, java.lang.CharSequence name) {
    this.species = species;
    this.color = color;
    this.name = name;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return species;
    case 1: return color;
    case 2: return name;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: species = (java.lang.CharSequence)value$; break;
    case 1: color = (java.lang.CharSequence)value$; break;
    case 2: name = (java.lang.CharSequence)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'species' field.
   * @return What species the dog this is
   */
  public java.lang.CharSequence getSpecies() {
    return species;
  }


  /**
   * Sets the value of the 'species' field.
   * What species the dog this is
   * @param value the value to set.
   */
  public void setSpecies(java.lang.CharSequence value) {
    this.species = value;
  }

  /**
   * Gets the value of the 'color' field.
   * @return What color the dog is
   */
  public java.lang.CharSequence getColor() {
    return color;
  }


  /**
   * Sets the value of the 'color' field.
   * What color the dog is
   * @param value the value to set.
   */
  public void setColor(java.lang.CharSequence value) {
    this.color = value;
  }

  /**
   * Gets the value of the 'name' field.
   * @return The name of the dog
   */
  public java.lang.CharSequence getName() {
    return name;
  }


  /**
   * Sets the value of the 'name' field.
   * The name of the dog
   * @param value the value to set.
   */
  public void setName(java.lang.CharSequence value) {
    this.name = value;
  }

  /**
   * Creates a new Dog RecordBuilder.
   * @return A new Dog RecordBuilder
   */
  public static com.github.zacharydhamilton.events.animals.Dog.Builder newBuilder() {
    return new com.github.zacharydhamilton.events.animals.Dog.Builder();
  }

  /**
   * Creates a new Dog RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Dog RecordBuilder
   */
  public static com.github.zacharydhamilton.events.animals.Dog.Builder newBuilder(com.github.zacharydhamilton.events.animals.Dog.Builder other) {
    if (other == null) {
      return new com.github.zacharydhamilton.events.animals.Dog.Builder();
    } else {
      return new com.github.zacharydhamilton.events.animals.Dog.Builder(other);
    }
  }

  /**
   * Creates a new Dog RecordBuilder by copying an existing Dog instance.
   * @param other The existing instance to copy.
   * @return A new Dog RecordBuilder
   */
  public static com.github.zacharydhamilton.events.animals.Dog.Builder newBuilder(com.github.zacharydhamilton.events.animals.Dog other) {
    if (other == null) {
      return new com.github.zacharydhamilton.events.animals.Dog.Builder();
    } else {
      return new com.github.zacharydhamilton.events.animals.Dog.Builder(other);
    }
  }

  /**
   * RecordBuilder for Dog instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Dog>
    implements org.apache.avro.data.RecordBuilder<Dog> {

    /** What species the dog this is */
    private java.lang.CharSequence species;
    /** What color the dog is */
    private java.lang.CharSequence color;
    /** The name of the dog */
    private java.lang.CharSequence name;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.github.zacharydhamilton.events.animals.Dog.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.species)) {
        this.species = data().deepCopy(fields()[0].schema(), other.species);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.color)) {
        this.color = data().deepCopy(fields()[1].schema(), other.color);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.name)) {
        this.name = data().deepCopy(fields()[2].schema(), other.name);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing Dog instance
     * @param other The existing instance to copy.
     */
    private Builder(com.github.zacharydhamilton.events.animals.Dog other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.species)) {
        this.species = data().deepCopy(fields()[0].schema(), other.species);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.color)) {
        this.color = data().deepCopy(fields()[1].schema(), other.color);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.name)) {
        this.name = data().deepCopy(fields()[2].schema(), other.name);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'species' field.
      * What species the dog this is
      * @return The value.
      */
    public java.lang.CharSequence getSpecies() {
      return species;
    }


    /**
      * Sets the value of the 'species' field.
      * What species the dog this is
      * @param value The value of 'species'.
      * @return This builder.
      */
    public com.github.zacharydhamilton.events.animals.Dog.Builder setSpecies(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.species = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'species' field has been set.
      * What species the dog this is
      * @return True if the 'species' field has been set, false otherwise.
      */
    public boolean hasSpecies() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'species' field.
      * What species the dog this is
      * @return This builder.
      */
    public com.github.zacharydhamilton.events.animals.Dog.Builder clearSpecies() {
      species = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'color' field.
      * What color the dog is
      * @return The value.
      */
    public java.lang.CharSequence getColor() {
      return color;
    }


    /**
      * Sets the value of the 'color' field.
      * What color the dog is
      * @param value The value of 'color'.
      * @return This builder.
      */
    public com.github.zacharydhamilton.events.animals.Dog.Builder setColor(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.color = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'color' field has been set.
      * What color the dog is
      * @return True if the 'color' field has been set, false otherwise.
      */
    public boolean hasColor() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'color' field.
      * What color the dog is
      * @return This builder.
      */
    public com.github.zacharydhamilton.events.animals.Dog.Builder clearColor() {
      color = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'name' field.
      * The name of the dog
      * @return The value.
      */
    public java.lang.CharSequence getName() {
      return name;
    }


    /**
      * Sets the value of the 'name' field.
      * The name of the dog
      * @param value The value of 'name'.
      * @return This builder.
      */
    public com.github.zacharydhamilton.events.animals.Dog.Builder setName(java.lang.CharSequence value) {
      validate(fields()[2], value);
      this.name = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'name' field has been set.
      * The name of the dog
      * @return True if the 'name' field has been set, false otherwise.
      */
    public boolean hasName() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'name' field.
      * The name of the dog
      * @return This builder.
      */
    public com.github.zacharydhamilton.events.animals.Dog.Builder clearName() {
      name = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Dog build() {
      try {
        Dog record = new Dog();
        record.species = fieldSetFlags()[0] ? this.species : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.color = fieldSetFlags()[1] ? this.color : (java.lang.CharSequence) defaultValue(fields()[1]);
        record.name = fieldSetFlags()[2] ? this.name : (java.lang.CharSequence) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Dog>
    WRITER$ = (org.apache.avro.io.DatumWriter<Dog>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Dog>
    READER$ = (org.apache.avro.io.DatumReader<Dog>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.species);

    out.writeString(this.color);

    out.writeString(this.name);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.species = in.readString(this.species instanceof Utf8 ? (Utf8)this.species : null);

      this.color = in.readString(this.color instanceof Utf8 ? (Utf8)this.color : null);

      this.name = in.readString(this.name instanceof Utf8 ? (Utf8)this.name : null);

    } else {
      for (int i = 0; i < 3; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.species = in.readString(this.species instanceof Utf8 ? (Utf8)this.species : null);
          break;

        case 1:
          this.color = in.readString(this.color instanceof Utf8 ? (Utf8)this.color : null);
          break;

        case 2:
          this.name = in.readString(this.name instanceof Utf8 ? (Utf8)this.name : null);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}









