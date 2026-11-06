const t = { get: ["mes_ship_summary:get"], detail: ["mes_ship_summary:detail"], print: ["mes_ship_summary:print"] }, a = { get: ["enclosure_ship_summary:get"], detail: ["enclosure_ship_summary:detail"], print: ["enclosure_ship_summary:print"] }, s = { get: ["aux_ship_summary:get"] }, r = { get: ["bridge_ship_summary:get"], detail: ["bridge_ship_summary:detail"], print: ["bridge_ship_summary:print"] }, e = { pack: ["mes_manual_pack:pack"] }, i = { get: ["mes_manual_pack_artifact:get"], pack: e.pack };
e.pack;
const n = { get: ["mes_pack:get"], detail: ["mes_pack:detail"], edit: e.pack, del: ["mes_pack:del"], print: ["mes_pack:print"], printRecords: ["mes_pack:printRecords"], printPackList: ["mes_pack:printPackList"] }, c = { get: ["mes_ship:get"], detail: ["mes_ship:detail"], print: ["mes_ship:print"], detailPrint: ["mes_ship:detailPrint"] }, d = { get: ["mes_receipt_status:get"], detail: ["mes_receipt_status:detail"], print: ["mes_receipt_status:print"], detailPrint: ["mes_receipt_status:detailPrint"], cancelDelivery: ["mes_receipt_status:cancelDelivery"], confirmDelivery: ["mes_receipt_status:confirmDelivery"] }, o = { get: ["mes_logistics:get"], edit: ["mes_logistics:edit"], print: ["mes_logistics:print"] }, u = { get: ["warehouse_management_induction:get"], submit: ["warehouse_management_induction:submit"] }, _ = { get: ["warehouse_management_data:get"], submit: ["warehouse_management_data:submit"] }, p = { get: ["mes_ship_audit:get"], detail: ["mes_ship_audit:detail"], print: ["mes_ship_audit:print"], detailPrint: ["mes_ship_audit:detailPrint"], download: ["mes_ship_audit:download"], audit: ["mes_ship_audit:audit"] }, m = { get: ["mes_product-send-receive-storage:get"], print: ["mes_product-send-receive-storage:print"], detail: ["mes_product-send-receive-storage:detail"], detailPrint: ["mes_product-send-receive-storage:detailPrint"] }, g = { get: ["enclosure_product-send-receive-storage:get"], print: ["enclosure_product-send-receive-storage:print"], detail: ["enclosure_product-send-receive-storage:detail"], detailPrint: ["enclosure_product-send-receive-storage:detailPrint"] }, l = { get: ["box_product-send-receive-storage:get"], print: ["box_product-send-receive-storage:print"], detail: ["box_product-send-receive-storage:detail"], detailPrint: ["box_product-send-receive-storage:detailPrint"] }, P = { get: ["manufactures_sales_return:get"], create: ["manufactures_sales_return:create"], audit: ["manufactures_sales_return:audit"], print: ["manufactures_sales_return:print"], detail: ["manufactures_sales_return:detail"], detailPrint: ["manufactures_sales_return:detailPrint"] }, h = { get: ["waste_storage_handle:get"], submit: ["waste_storage_handle:submit"] }, k = { get: ["waste_storage_record:get"], audit: ["waste_storage_record:audit"], print: ["waste_storage_record:print"], detail: ["waste_storage_record:detail"], detailPrint: ["waste_storage_record:detailPrint"] }, M = { get: ["structural_products:get"], pack: ["structural_products:pack"] }, w = { get: ["enclosure_products:get"], pack: ["enclosure_products:pack"] }, S = { get: ["supporting_products:get"], pack: ["supporting_products:pack"] }, v = { get: ["pack_manage_operation:get"], pack: ["pack_manage_operation:pack"] }, b = { get: ["weighbridge_management:get"], editStatus: ["weighbridge_management:editStatus"] };
export {
  i as a,
  e as b,
  S as c,
  n as d,
  w as e,
  l as f,
  m as g,
  g as h,
  p as i,
  c as j,
  s as k,
  o as l,
  P as m,
  r as n,
  a as o,
  v as p,
  t as q,
  d as r,
  M as s,
  u as t,
  h as u,
  k as v,
  _ as w,
  b as x
};
