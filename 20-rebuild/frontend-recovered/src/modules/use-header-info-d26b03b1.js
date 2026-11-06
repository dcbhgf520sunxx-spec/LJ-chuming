import { useRouter as z } from "vue-router";
import { inject as F } from "vue";
import { ref as t } from "vue";
import { B as H, pB as L } from "../shared/runtime.js";
function V({ defaultBasicClass: i, defaultBoolPartyA: l, defaultProjectWarehouseType: f = L.PUBLIC.V }) {
  const u = z(), d = F("permission"), b = { projectId: { value: void 0, resetAble: false }, projectWarehouseType: { value: f, resetAble: false }, basicClass: { value: i, resetAble: false }, boolPartyA: { value: l, resetAble: false } }, { CRUD: h, crud: e, query: p } = H(b), n = t(), o = t(false), a = t(false), r = t(false), s = t(false);
  function v() {
    u.push({ name: "WMSOutboundRecord-ptA" });
  }
  function m() {
    o.value = true;
  }
  function y() {
    c(), e.toQuery();
  }
  function O() {
    a.value = true;
  }
  function g() {
    e.toQuery();
  }
  function B() {
    r.value = true;
  }
  function I() {
    e.toQuery();
  }
  function R() {
    s.value = true;
  }
  function A() {
    e.toQuery();
  }
  function M() {
    u.push({ name: "WMSRawMatFreezeList" });
  }
  function c() {
    n.value && n.value.updateListNumber();
  }
  return { CRUD: h, crud: e, query: p, permission: d, currentUserOutboundListRef: n, batchOutboundHandlingVisible: o, batchTransferHandlingVisible: a, batchMovingInventoryHandlingVisible: s, batchFreezeHandlingVisible: r, updateListNumber: c, toOutboundRecord: v, toBatchOutbound: m, toBatchFreeze: B, handleBatchOutbound: y, toBatchTransfer: O, toBatchMovingInventory: R, handleTransferOutbound: g, handleFreezeOutbound: I, handleMovingInventoryOutbound: A, openFreezeRecords: M };
}
export {
  V as u
};
