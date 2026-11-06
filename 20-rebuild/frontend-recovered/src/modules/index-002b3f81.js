import { a9 as S, i as V, iX as E, a$ as q, _ as L } from "../shared/runtime.js";
import { c as y, a as T } from "./common-ac6e385c.js";
import { ref as w } from "vue";
import { watch as C } from "vue";
import { openBlock as O } from "vue";
import { createBlock as W } from "vue";
import { withCtx as H } from "vue";
import { createElementBlock as Q } from "vue";
import { Fragment as D } from "vue";
import { renderList as k } from "vue";
import { ElStep as v } from "element-plus";
import { ElSteps as x } from "element-plus";
function K() {
  return { handleAssembleList: B, handleCompareAssembleList: $, handleComparePartList: P };
}
function B(s, h) {
  var a;
  const d = [], l = {}, m = [], o = {}, n = [], r = [], u = [], p = S(s, "serialNumber");
  for (let i = 0; i < h.length; i++) {
    const e = h[i], f = p[e.serialNumber];
    if (e.changeTypeEnum && (e.operateType = e.changeTypeEnum & y.EDIT.V ? T.EDIT.V : T.NEW.V), (a = e == null ? void 0 : e.changeAssembleLinkList) != null && a.length) {
      e.handleObj = {}, e.oldSerialNumbers = [];
      for (const g of e.changeAssembleLinkList) e.handleObj[g.oldAssembleSerialNumber] = { ...g, handleType: g.assembleChangeTypeEnum }, e.oldSerialNumbers.push(g.oldAssembleSerialNumber);
    }
    if (V(f)) if (u.push(`${e.serialNumber}`), f.quantity === e.quantity) {
      r.push({ newAssemble: e, oldAssemble: f });
      continue;
    } else {
      const g = f.quantity - e.quantity, b = e.diffQuantity > 0 ? y.REDUCE.V : y.ADD.V, t = E(f.totalNetWeight - e.totalNetWeight, 2);
      n.push({ newAssemble: e, oldAssemble: f, changeType: b, diffQuantity: g, diffTotalWeight: t });
    }
    else e.operateType || (e.operateType = T.NEW.V), m.push(e), o[e.serialNumber] = e;
  }
  for (let i = 0; i < s.length; i++) {
    const e = s[i], f = `${e.serialNumber}`;
    u.includes(f) || (d.push(e), l[e.serialNumber] = e);
  }
  return { needHandleOldList: d, needHandleNewList: m, needHandleOldObj: l, needHandleNewObj: o, amList: n, sameList: r };
}
function $(s) {
  var o, n, r, u, p, a, i, e, f, g;
  let h = true;
  const d = [], l = [], m = [];
  for (let b = 0; b < s.needHandleNewList.length; b++) {
    const t = s.needHandleNewList[b];
    if ((!t.operateType || t.operateType !== T.NEW.V && !((o = t.oldSerialNumbers) != null && o.length)) && (h = false), t.operateType === T.NEW.V) {
      const N = y.NEW.V, c = -t.quantity, _ = -t.totalNetWeight;
      d.push({ newAssemble: t, oldAssemble: {}, changeType: N, diffQuantity: c, diffTotalWeight: _ });
    }
    if (t.operateType !== T.NEW.V && ((n = t.oldSerialNumbers) != null && n.length)) for (let N = 0; N < t.oldSerialNumbers.length; N++) {
      const c = t.oldSerialNumbers[N];
      if (l.push(c), !t.handleObj[c] || !((r = t.handleObj[c]) != null && r.handleType) || !((u = t.handleObj[c]) != null && u.quantity)) {
        h = false;
        continue;
      }
      const _ = y.EDIT.V, A = ((p = t.handleObj[c]) == null ? void 0 : p.quantity) - t.quantity, j = E(((a = t.handleObj[c]) == null ? void 0 : a.quantity) * ((i = t.handleObj[c]) == null ? void 0 : i.netWeight) - t.totalNetWeight, 2);
      d.push({ newAssemble: t, oldAssemble: (e = s == null ? void 0 : s.needHandleOldObj) == null ? void 0 : e[c], oldQuantity: (f = t.handleObj[c]) == null ? void 0 : f.quantity, handleType: (g = t.handleObj[c]) == null ? void 0 : g.handleType, changeType: _, diffQuantity: A, diffTotalWeight: j });
    }
  }
  if (h && l.length !== s.needHandleOldList.length) for (let b = 0; b < s.needHandleOldList.length; b++) {
    const t = s.needHandleOldList[b];
    if (!l.includes(t.serialNumber)) {
      const N = y.DEL.V, c = t.quantity, _ = t.totalNetWeight;
      m.push({ newAssemble: {}, oldAssemble: t, changeType: N, diffQuantity: c, diffTotalWeight: _ });
    }
  }
  return { assembleCompareList: [...d, ...s == null ? void 0 : s.amList, ...m], isAssembleHandled: h };
}
function P(s, h) {
  const d = {}, l = S(s, "serialNumber"), m = {};
  for (let o = 0; o < h.length; o++) {
    const n = h[o], r = l[n.serialNumber];
    m[n.serialNumber] = n;
    const u = n.quantity;
    let p, a, i, e;
    if (!r) p = y.NEW.V, e = 0, a = -u, i = -n.totalNetWeight;
    else {
      if (r.quantity === n.quantity) continue;
      e = r.quantity, a = r.quantity - u, i = E(r.totalNetWeight - n.totalNetWeight, 2), p = n.diffQuantity > 0 ? y.REDUCE.V : y.ADD.V;
    }
    d[n.serialNumber] = { ...n, changeType: p, diffQuantity: a, diffTotalWeight: i, oldQuantity: e, newQuantity: u };
  }
  for (let o = 0; o < s.length; o++) {
    const n = s[o], r = n.quantity;
    let u, p, a, i;
    if (!m[n.serialNumber]) u = y.DEL.V, p = r, a = n.totalNetWeight, i = 0;
    else continue;
    d[n.serialNumber] = { ...n, oldQuantity: r, changeType: u, diffQuantity: p, diffTotalWeight: a, newQuantity: i };
  }
  return q(d);
}
const R = { __name: "index", props: { modelValue: { type: Number, default: void 0 }, options: { type: [Array, Object], default: () => [] }, space: { type: [Number, String] }, direction: { type: String, default: "horizontal" }, processStatus: { type: String, default: "process" }, finishStatus: { type: String, default: "finish" }, alignCenter: { type: Boolean, default: false }, simple: { type: Boolean, default: false } }, emits: ["update:modelValue", "change"], setup(s, { emit: h }) {
  const d = h, l = s, m = w();
  C(() => l.modelValue, (n) => {
    m.value = n;
  });
  function o(n) {
    d("update:modelValue", n), d("change", n);
  }
  return (n, r) => {
    const u = v, p = x;
    return O(), W(p, { space: l.space, active: m.value, direction: l.direction, "process-status": l.processStatus, "finish-status": l.finishStatus, "align-center": l.alignCenter, simple: l.simple, class: "common-step", onChange: o }, { default: H(() => [(O(true), Q(D, null, k(s.options, (a) => (O(), W(u, { key: a.title, title: a.title, description: a.description, icon: a.icon, status: a.status }, null, 8, ["title", "description", "icon", "status"]))), 128))]), _: 1 }, 8, ["space", "active", "direction", "process-status", "finish-status", "align-center", "simple"]);
  };
} }, X = L(R, [["__scopeId", "data-v-c0206879"]]);
export {
  X as c,
  K as u
};
