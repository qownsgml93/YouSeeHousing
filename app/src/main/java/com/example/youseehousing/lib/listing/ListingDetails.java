package com.example.youseehousing.lib.listing;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.example.youseehousing.R;
import com.example.youseehousing.lib.ui.RecyclerViewListItem;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

/**
 * A list item representing a piece of content.
 * This class implements Parcelable so it can pass its data to the MainListingPage activity.
 * DONE: This definitely deserves its own class where it dynamically pulls content from the database
 *        based on its id and populates these parameters with that information. DONE!
 */

public class ListingDetails extends RecyclerViewListItem implements Parcelable, Cloneable {

    private static final String TAG = "ListingDetails";
//    private String id;
    private String address;
    private String bath;
    private String bed;
    private String buildingLease;
    private String contact;
    private ArrayList<String> coordinates;
    private String desc;
    private String dim;
    private String furnished;
    private String link;
    private String parking;
    private ArrayList<String> pictures;
    private String pet;
    private String price;
    private String unitLease;
    private String washerDryer;

    private final String[] queryList = {    "address", "bath", "bed",
                                            "buildingLease", "contact", "coordinates", "desc",
                                            "dim", "furnished", "link", "parking",
                                            "pictures", "pet", "price",
                                            "unitLease", "washerDryer"};

    public ListingDetails() {}

    public ListingDetails(String address,
                          String bath,
                          String bed,
                          String buildingLease,
                          String contact,
                          ArrayList<String> coordinates,
                          String desc,
                          String dim,
                          String furnished,
                          String link,
                          String parking,
                          ArrayList<String> pictures,
                          String pet,
                          String price,
                          String unitLease,
                          String washerDryer
                          ) {
//        this.id = id;
        this.address = address;
        this.bath = bath;
        this.bed = bed;
        this.buildingLease = buildingLease;
        this.contact = contact;
        this.coordinates = coordinates;
        this.desc = desc;
        this.dim = dim;
        this.furnished = furnished;
        this.link = link;
        this.parking = parking;
        this.pictures = pictures;
        this.pet = pet;
        this.price = price;
        this.unitLease = unitLease;
        this.washerDryer = washerDryer;
    }

    protected ListingDetails(Parcel in) {
//      this.id = in.readString();
        this.address = in.readString();
        this.bath = in.readString();
        this.bed = in.readString();
        this.buildingLease = in.readString();
        this.contact = in.readString();
        this.coordinates = (ArrayList<String>) in.readSerializable();
        this.desc = in.readString();
        this.dim = in.readString();
        this.furnished = in.readString();
        this.link = in.readString();
        this.parking = in.readString();
        this.pictures = (ArrayList<String>) in.readSerializable();
        this.pet = in.readString();
        this.price = in.readString();
        this.unitLease = in.readString();
        this.washerDryer = in.readString();
    }

    @Override
    public String toString() {
        return address;
    }

    //getters
//    public String getId() {
//        return this.id;
//    }


    public String getAddress() {
        return this.address;
    }
    public String getBath() {
        return bath;
    }
    public String getBed() {
        return bed;
    }
    public String getBuildingLease() {
        return buildingLease;
    }
    public String getContact() {
        return contact;
    }
    public ArrayList<String> getCoordinates() {
        return coordinates;
    }
    public String getDesc() {
        return desc;
    }
    public String getDim() {
        return dim;
    }
    public String getFurnished() {
        if (furnished != null) {
            if(furnished.contains("true")) {
                return "Furnished";
            }
        }
        return "Not Furnished";
    }
    public String getLink() {
        return link;
    }
    public String getParking() {
        return parking;
    }
    public ArrayList<String> getPictures() {
        return pictures;
    }
    public String getPet() {
        return pet;
    }
    public String getPrice() {
        return price;
    }
    public String getUnitLease() {
        return unitLease;
    }
    public String getWasherDryer() {
        return washerDryer;
    }

    //setters
    public void setAddress(String address) {
        this.address = address;
    }
    public void setBath(String bath) {
        this.bath = bath;
    }
    public void setBed(String bed) {
        this.bed = bed;
    }
    public void setBuildingLease(String buildingLease) {
        this.buildingLease = buildingLease;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public void setCoordinates(ArrayList<String> coordinates) {
        this.coordinates = coordinates;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public void setDim(String dim) {
        this.dim = dim;
    }
    public void setLink(String link) {
        this.link = link;
    }
    public void setParking(String parking) {
        this.parking = parking;
    }
    public void setPictures(ArrayList<String> pictures) {
        this.pictures = pictures;
    }
    public void setPet(String pet) {
        this.pet = pet;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public void setUnitLease(String unitLease) {
        this.unitLease = unitLease;
    }
    public void setWasherDryer(String washerDryer) {
        this.washerDryer = washerDryer;
    }
    public void setFurnished(String furnished) {
        this.furnished = furnished;
    }

    // Begin implemented Parcelable methods

    public static final Creator<ListingDetails> CREATOR = new Creator<ListingDetails>() {
        @Override
        public ListingDetails createFromParcel(Parcel in) {
            return new ListingDetails(in);
        }

        @Override
        public ListingDetails[] newArray(int size) {
            return new ListingDetails[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(id);
        dest.writeString(address);
        dest.writeString(bath);
        dest.writeString(bed);
        dest.writeString(buildingLease);
        dest.writeString(contact);
        dest.writeSerializable(coordinates);
        dest.writeString(desc);
        dest.writeString(dim);
        dest.writeString(furnished);
        dest.writeString(link);
        dest.writeString(parking);
        dest.writeSerializable(pictures);
        dest.writeString(pet);
        dest.writeString(price);
        dest.writeString(unitLease);
        dest.writeString(washerDryer);

    }
    // End implemented Parcelable methods

    /**
     * Creates a ListingDetails object from a QueryDocumentSnapshot object returned from a
     * Cloud Firestore query.
     *
     * @param document
     * @return
     */
    public static ListingDetails makeListingDetailsFromDocumentSnapshot(QueryDocumentSnapshot document) {
//                "address", "bath", "bed",
//                "buildingLease", "contact", "coordinates", "desc",
//                "dim", "link", "parking",
//                "pictures", "pet", "price",
//                "unitLease", "washerDryer"
        // TODO: If any field is null, return a default string.
        if (document.exists()) {
            String address = document.get("address").toString(); // Address
            String bath = document.get("bath").toString(); // Bath
            String bed = document.get("bed").toString(); // bed
            String buildingLease = document.get("buildingLease").toString(); // Bath
            String contact = document.get("contact").toString(); // contact

            ArrayList<String> coordinates = (ArrayList<String>) document.get("coordinates"); // parking
            if(coordinates.isEmpty()) {
                coordinates.add("");
            }

            String desc = document.get("desc").toString(); // desc
            String dim = document.get("dim").toString(); // dim
            String furnished = document.get("furnished").toString(); // furnished
            String link = document.get("link").toString(); // link
            String parking = document.get("parking").toString(); // parking

            // ass a default array with a length > 0 if this is null
            ArrayList<String> pictures = (ArrayList<String>) document.get("pictures"); // parking
            if(pictures.isEmpty()) {
                pictures.add("");
            }

            String pet = document.get("pet").toString(); // pet
            String price = document.get("price").toString(); // dim
            String unitLease = document.get("unitLease").toString(); // Bath
            String washerDryer = document.get("washerDryer").toString(); // Bath

            Log.i(TAG, "Queried db: " + address);

            return new ListingDetails(address, bath, bed, buildingLease, contact, coordinates,
                    desc, dim, furnished, link, parking, pictures, pet, price, unitLease, washerDryer);
        } else {
            return null;
        }
    }

    /**
     * Returns a valid image URL.
     * @param item - the ListingDetails object
     * @param index - the index of the image to get
     * @return Returns an image URL at the index, or "" if there is no image url
     */
    public static String getImageURL(ListingDetails item, int index) {
        String defaultURL = "";
        List<String> pictureList = item.getPictures();
        int numPictures = pictureList.size();

        // Case where pictures is empty
        if(numPictures <= 0) {
            return defaultURL;
        }
        // Case where index is greater than numPictures : Return last image in list
        if(index > numPictures-1){
            return pictureList.get(numPictures-1);
        }
        // Case where index is less than 0 : Return first image in list
        if(index < 0){
            return pictureList.get(0);
        }
        return pictureList.get(index);
    }

    /**
     * Returns the number of images in the ListingDetails item
     * Returns 0 if images is null!
     */
    public int getNumImages() {
        if (getPictures() != null) {
            return getPictures().size();
        }
        else {
            return 0;
        }
    }

    public ArrayList<String> getListOfImages() {
        if (getNumImages() <= 0) {
            return new ArrayList<String>();
        }
        else return pictures;
    }

    /**
     * from https://medium.com/@hamidgh/sending-objects-to-fragment-naive-question-is-it-sent-by-value-ddaaa19fa42d
     * @return
     */
    @Override
    public Object clone() {
        Parcel parcel = Parcel.obtain();
        this.writeToParcel(parcel, 0);
        byte[] bytes = parcel.marshall();

        Parcel parcel2 = Parcel.obtain();
        parcel2.unmarshall(bytes, 0, bytes.length);
        parcel2.setDataPosition(0);
        return ListingDetails.CREATOR.createFromParcel(parcel2);
    }
}
