package com.tradinos.mzn.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class OrderDetails {


    private int id;
    private int status;
    private String address;
    private String created_date;
    private String delivery_date;
    private int delivery_time;
    private double total;
    private int user_id;
    private String note;
    private String area;
    private String street;
    private String house_number;
    @SerializedName("long")
    private String lng;
    private String lat;
    private int city_id;
    private String order_img;
    private String payment_method;
    private String payment_status;
    private int delivery_fee;
    private int send_to_friend;
    private String friend_message;
    private int add_card;
    private int card_id;
    private int card_fee;
    private String friend_name;
    private String friend_phone;
    private double tax;
    private int subtotal;
    private int tax_per;
    private String voucher_id;
    private String voucher_per;
    private String voucher_value;
    private String start;
    private String end;
    private ArrayList<ArrangementInOrderDetails> arrangments;
    private ArrayList<TrayInOrderDetails> trays;
    private City city;
    private CardType card;
    private String voucher;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(String delivery_date) {
        this.delivery_date = delivery_date;
    }

    public int getDelivery_time() {
        return delivery_time;
    }

    public void setDelivery_time(int delivery_time) {
        this.delivery_time = delivery_time;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse_number() {
        return house_number;
    }

    public void setHouse_number(String house_number) {
        this.house_number = house_number;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getOrder_img() {
        return order_img;
    }

    public void setOrder_img(String order_img) {
        this.order_img = order_img;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

    public int getDelivery_fee() {
        return delivery_fee;
    }

    public void setDelivery_fee(int delivery_fee) {
        this.delivery_fee = delivery_fee;
    }

    public int getSend_to_friend() {
        return send_to_friend;
    }

    public void setSend_to_friend(int send_to_friend) {
        this.send_to_friend = send_to_friend;
    }

    public String getFriend_message() {
        return friend_message;
    }

    public void setFriend_message(String friend_message) {
        this.friend_message = friend_message;
    }

    public int getAdd_card() {
        return add_card;
    }

    public void setAdd_card(int add_card) {
        this.add_card = add_card;
    }

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public int getCard_fee() {
        return card_fee;
    }

    public void setCard_fee(int card_fee) {
        this.card_fee = card_fee;
    }

    public String getFriend_name() {
        return friend_name;
    }

    public void setFriend_name(String friend_name) {
        this.friend_name = friend_name;
    }

    public String getFriend_phone() {
        return friend_phone;
    }

    public void setFriend_phone(String friend_phone) {
        this.friend_phone = friend_phone;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public int getTax_per() {
        return tax_per;
    }

    public void setTax_per(int tax_per) {
        this.tax_per = tax_per;
    }

    public String getVoucher_id() {
        return voucher_id;
    }

    public void setVoucher_id(String voucher_id) {
        this.voucher_id = voucher_id;
    }

    public String getVoucher_per() {
        return voucher_per;
    }

    public void setVoucher_per(String voucher_per) {
        this.voucher_per = voucher_per;
    }

    public String getVoucher_value() {
        return voucher_value;
    }

    public void setVoucher_value(String voucher_value) {
        this.voucher_value = voucher_value;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public ArrayList<ArrangementInOrderDetails> getArrangments() {
        return arrangments;
    }

    public void setArrangments(ArrayList<ArrangementInOrderDetails> arrangments) {
        this.arrangments = arrangments;
    }

    public ArrayList<TrayInOrderDetails> getTrays() {
        return trays;
    }

    public void setTrays(ArrayList<TrayInOrderDetails> trays) {
        this.trays = trays;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public CardType getCard() {
        return card;
    }

    public void setCard(CardType card) {
        this.card = card;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public class ArrangementInOrderDetails{

        private int id;
        private String name;
        private int price;
        private String description;
        private String image_url;
        private String trans_img;
        private int activated;
        private String color;
        private String size;
        private ArrangementInOrderDetailsPivot pivot;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getTrans_img() {
            return trans_img;
        }

        public void setTrans_img(String trans_img) {
            this.trans_img = trans_img;
        }

        public int getActivated() {
            return activated;
        }

        public void setActivated(int activated) {
            this.activated = activated;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public ArrangementInOrderDetailsPivot getPivot() {
            return pivot;
        }

        public void setPivot(ArrangementInOrderDetailsPivot pivot) {
            this.pivot = pivot;
        }

        public class ArrangementInOrderDetailsPivot{
            private int mzn_order_id;
            private int mzn_arrangment_id;
            private int quantity;
            private int arrangment_price;
            private String note;
            private int size_id;
            private int color_id;



            public int getMzn_order_id() {
                return mzn_order_id;
            }

            public void setMzn_order_id(int mzn_order_id) {
                this.mzn_order_id = mzn_order_id;
            }

            public int getMzn_arrangment_id() {
                return mzn_arrangment_id;
            }

            public void setMzn_arrangment_id(int mzn_arrangment_id) {
                this.mzn_arrangment_id = mzn_arrangment_id;
            }

            public int getQuantity() {
                return quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }

            public int getArrangment_price() {
                return arrangment_price;
            }

            public void setArrangment_price(int arrangment_price) {
                this.arrangment_price = arrangment_price;
            }

            public String getNote() {
                return note;
            }

            public void setNote(String note) {
                this.note = note;
            }

            public int getSize_id() {
                return size_id;
            }

            public void setSize_id(int size_id) {
                this.size_id = size_id;
            }

            public int getColor_id() {
                return color_id;
            }

            public void setColor_id(int color_id) {
                this.color_id = color_id;
            }
        }
    }

    public class TrayInOrderDetails{

        private int id;
        private String name;
        private String description;
        private String image_url;
        private int activated;
        private int price;
        private TrayInOrderDetailsPivot pivot;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public int getActivated() {
            return activated;
        }

        public void setActivated(int activated) {
            this.activated = activated;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public TrayInOrderDetailsPivot getPivot() {
            return pivot;
        }

        public void setPivot(TrayInOrderDetailsPivot pivot) {
            this.pivot = pivot;
        }

        public class TrayInOrderDetailsPivot{

            private int mzn_order_id;
            private int mzn_tray_id;
            private int quantity;
            private int tray_price;
            private String note;

            public int getMzn_order_id() {
                return mzn_order_id;
            }

            public void setMzn_order_id(int mzn_order_id) {
                this.mzn_order_id = mzn_order_id;
            }

            public int getMzn_tray_id() {
                return mzn_tray_id;
            }

            public void setMzn_tray_id(int mzn_tray_id) {
                this.mzn_tray_id = mzn_tray_id;
            }

            public int getQuantity() {
                return quantity;
            }

            public void setQuantity(int quantity) {
                this.quantity = quantity;
            }

            public int getTray_price() {
                return tray_price;
            }

            public void setTray_price(int tray_price) {
                this.tray_price = tray_price;
            }

            public String getNote() {
                return note;
            }

            public void setNote(String note) {
                this.note = note;
            }
        }

    }
}
