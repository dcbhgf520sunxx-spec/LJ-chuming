import { useRouter as z } from "vue-router";
import { inject as A } from "vue";
import { ref as n } from "vue";
import { pB as F, B as H } from "../shared/runtime.js";
function T({ defaultBasicClass: l, defaultBoolPartyA: f, defaultProjectWarehouseType: d }) {
  const u = z(), b = A("permission"), o = { projectId: { value: void 0, resetAble: false }, basicClass: { value: l, resetAble: false }, boolPartyA: { value: f, resetAble: false } };
  d !== -1 && (o.projectWarehouseType = { value: F.PUBLIC.V, resetAble: false });
  const { CRUD: h, crud: e, query: p } = H(o), t = n(), a = n(false), r = n(false), s = n(false), i = n(false);
  function v() {
    u.push({ name: "WMSOutboundRecord-V2" });
  }
  function m() {
    a.value = true;
  }
  function y() {
    i.value = true;
  }
  function O() {
    c(), e.toQuery();
  }
  function g() {
    r.value = true;
  }
  function B() {
    s.value = true;
  }
  function I() {
    e.toQuery();
  }
  function R() {
    e.toQuery();
  }
  function M() {
    e.toQuery();
  }
  function V() {
    u.push({ name: "WMSRawMatFreezeList" });
  }
  function c() {
    t.value && t.value.updateListNumber();
  }
  return { CRUD: h, crud: e, query: p, permission: b, currentUserOutboundListRef: t, batchOutboundHandlingVisible: a, batchTransferHandlingVisible: r, batchMovingInventoryHandlingVisible: s, batchFreezeHandlingVisible: i, updateListNumber: c, toOutboundRecord: v, toBatchOutbound: m, toBatchFreeze: y, handleBatchOutbound: O, toBatchTransfer: g, toBatchMovingInventory: B, handleTransferOutbound: I, handleFreezeOutbound: R, handleMovingInventoryOutbound: M, openFreezeRecords: V };
}
export {
  T as u
};
