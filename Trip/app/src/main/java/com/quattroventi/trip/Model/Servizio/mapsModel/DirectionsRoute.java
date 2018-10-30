

package com.quattroventi.trip.Model.Servizio.mapsModel;

import java.io.Serializable;
import java.util.Arrays;

/**
 * A Directions API result. When the Directions API returns results, it places them within a routes
 * array. Even if the service returns no results (such as if the origin and/or destination doesn't
 * exist) it still returns an empty routes array.
 *
 * <p>Please see <a href="https://developers.google.com/maps/documentation/directions/intro#Routes">
 * Routes</a> for more detail.
 */
public class DirectionsRoute implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * A short textual description for the route, suitable for naming and disambiguating the route
     * from alternatives.
     */
    public String summary;

    /**
     * Information about legs of the route, between locations within the route. A separate leg will be
     * present for each waypoint or destination specified. (A route with no waypoints will contain
     * exactly one leg within the legs array.)
     */
    public DirectionsLeg[] legs;

    /**
     * Indicates the order of any waypoints in the calculated route. This waypoints may be reordered
     * if the request was passed {@code optimize:true} within its {@code waypoints} parameter.
     */
    public int[] waypoint_order;

    /**
     * An approximate (smoothed) path of the resulting directions.
     */
    public EncodedPolyline overviewPolyline;

    /**
     * The viewport bounding box of the overview_polyline.
     */
    public Bounds bounds;

    /**
     * Copyrights text to be displayed for this route. You must handle and display this information
     * yourself.
     */
    public String copyrights;

    /**
     * Information about the fare (that is, the ticket costs) on this route. This property is only
     * returned for transit directions, and only for routes where fare information is available for
     * all transit legs.
     */
    public Fare fare;

    /**
     * Warnings to be displayed when showing these directions. You must handle and display these
     * warnings yourself.
     */
    public String[] warnings;

    public String toString() {
        String str =
                String.format(
                        "[DirectionsRoute: \"%s\", %d legs, waypointOrder=%s, bounds=%s",
                        summary, legs.length, Arrays.toString(waypoint_order), bounds);
        if (fare != null) {
            str = str + ", fare=" + fare;
        }
        if (warnings != null && warnings.length > 0) {
            str = str + ", " + warnings.length + " warnings";
        }
        str = str + "]";
        return str;
    }
}
