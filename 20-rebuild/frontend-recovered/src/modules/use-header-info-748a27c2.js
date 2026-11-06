import { useRouter as M } from "vue-router";
import { inject as z } from "vue";
import { ref as n } from "vue";
import { pB as F, B as H } from "../shared/runtime.js";
function T({ defaultBasicClass: i }) {
  const u = M(), l = z("permission"), d = { projectId: { value: void 0, resetAble: false }, projectWarehouseType: { value: F.PUBLIC.V, resetAble: false }, basicClass: { value: i, resetAble: false } }, { CRUD: f, crud: e, query: b } = H(d), t = n(), o = n(false), a = n(false), r = n(false), s = n(false);
  function h() {
    u.push({ name: "WMSOutboundRecord" });
  }
  function p() {
    o.value = true;
  }
  function v() {
    c(), e.toQuery();
  }
  function m() {
    a.value = true;
  }
  function y() {
    s.value = true;
  }
  function O() {
    r.value = true;
  }
  function g() {
    e.toQuery();
  }
  function B() {
    e.toQuery();
  }
  function I() {
    e.toQuery();
  }
  function R() {
    u.push({ name: "WMSRawMatFreezeList" });
  }
  function c() {
    t.value && t.value.updateListNumber();
  }
  return { CRUD: f, crud: e, query: b, permission: l, currentUserOutboundListRef: t, batchOutboundHandlingVisible: o, batchTransferHandlingVisible: a, batchMovingInventoryHandlingVisible: r, batchFreezeHandlingVisible: s, updateListNumber: c, toOutboundRecord: h, toBatchOutbound: p, toBatchFreeze: y, handleBatchOutbound: v, toBatchTransfer: m, toBatchMovingInventory: O, handleTransferOutbound: g, handleFreezeOutbound: I, handleMovingInventoryOutbound: B, openFreezeRecords: R };
}
export {
  T as u
};
