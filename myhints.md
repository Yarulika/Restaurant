My hints, tips, lessons learned

//    /{customerId}
//    @PathVariable Integer customerId

//    @RequestBody (vs ResponseBody, Param)
//    @RequestParam
//=================================================
SELECT * FROM restaurant.orders
WHERE person_id = 2;
----
SELECT person_id, SUM(cost) as summary
FROM orders
GROUP BY person_id
ORDER BY summary DESC