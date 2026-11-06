import { computed as j } from "vue";
import { ref as c } from "vue";
import { watch as H } from "vue";
import { resolveComponent as x } from "vue";
import { openBlock as C } from "vue";
import { createBlock as R } from "vue";
import { withCtx as w } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as y } from "vue";
import { createTextVNode as $ } from "vue";
import { toDisplayString as F } from "vue";
import { unref as n } from "vue";
import { createCommentVNode as z } from "vue";
import { isRef as Q } from "vue";
import { ElMessageBox as W } from "element-plus";
import { ElInput as Y } from "element-plus";
import { ElTree as G } from "element-plus";
import { ElCard as J } from "element-plus";
import { _ as K, aa as f, u as X, gt as Z, tk as ee, oW as te } from "../../../../../../shared/runtime.js";
import oe from "./match-detail/index.vue.js";
import "./match-detail/module/header.vue.js";
import "../../../../../../modules/plan-d12d7ccf.js";
import "./OAModal.vue.js";
import "../../components/drawing-upload-btn.vue.js";
import "../../../../../../modules/index-ce9deea8.js";
const le = { class: "detail-container" }, ne = { class: "left-card" }, ae = { class: "card-header" }, re = { class: "right-table" }, se = { __name: "detail", props: { modelValue: { type: Boolean, require: false }, currentRow: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} }, title: { type: String, default: "文件匹配详情" } }, emits: ["success", "update:modelValue"], setup(I, { emit: N }) {
  const p = I;
  j(() => f.ARTIFACT.V | f.ASSEMBLY.V | f.MACHINE_PART.V);
  const b = N, { visible: v, handleClose: S } = X({ emit: b, props: p, showHook: A }), u = c(), T = c(), g = c([]), h = c(), { crud: l } = Z(), k = { children: "areaSimpleList", label: "name" };
  async function A() {
    await B();
  }
  async function B() {
    try {
      const { content: e } = await ee({ projectId: p.currentRow.projectId, monomerId: p.currentRow.monomerId });
      e[0].areaSimpleList.forEach((t) => {
        var o;
        (o = t == null ? void 0 : t.planAreaBatchDTOS) != null && o.length && (t.areaSimpleList = t.planAreaBatchDTOS.map((a) => ({ ...a, isLot: true })));
      }), g.value = e;
    } catch (e) {
      console.log(e);
    }
  }
  const _ = c(true);
  H(() => [l.query.productType, l.query.steelPlateTypeEnum], async ([e, t], [o, a]) => {
    var r;
    l.query.productType === f.MACHINE_PART.V && ((r = u.value) == null || r.initUploadType()), _.value && await E(null, () => {
      l.query.productType = o, l.query.steelPlateTypeEnum = a;
    });
  });
  function P(e) {
    return new Promise((t, o) => {
      var a, r;
      W.confirm(`当前选中  ${(r = (a = u.value) == null ? void 0 : a.selectedIds) == null ? void 0 : r.length} 条 记录，确认切换“区域 / 批次”？`, "清空选中", { confirmButtonText: "确定", cancelButtonText: "取消", type: "warning" }).then(() => {
        var d;
        (d = u.value) == null || d.clearSelectIds(), _.value = true, t();
      }).catch(() => {
        _.value = false, e(), o();
      });
    });
  }
  async function E(e, t) {
    var o, a, r, d;
    try {
      ((a = (o = u.value) == null ? void 0 : o.selectedIds) == null ? void 0 : a.length) > 0 && await P(t), q.value = i.value, e != null && e.areaBatchId ? l.query.areaId = void 0 : e != null && e.areaId && (l.query.areaBatchId = void 0), Object.assign((r = u.value) == null ? void 0 : r.crud.query, l.query, e), await ((d = u.value) == null ? void 0 : d.crud.toQuery());
    } catch (V) {
      _.value = true, console.log(V);
    }
  }
  function L() {
    h.value.filter(T.value);
  }
  function M(e, t) {
    return e ? t.name.includes(e) : t;
  }
  const i = c(), q = c();
  async function U(e, t) {
    if (!e.hasOwnProperty("type")) return;
    i.value === e.id ? i.value = null : i.value = e.id;
    const o = {};
    e != null && e.isLot ? o.areaBatchId = i.value ? e.id : void 0 : o.areaId = i.value ? e.id : void 0, await E(o, () => {
      i.value = q.value;
    });
  }
  function D(e, { node: t, data: o, store: a }) {
    return e("div", { class: { "selected-node": i.value === o.id, "text-container": true }, title: o.name }, o.name);
  }
  function O() {
    var e;
    (e = u.value) == null || e.clearSelectIds();
  }
  return (e, t) => {
    const o = x("common-radio-button"), a = Y, r = G, d = J, V = x("common-drawer");
    return C(), R(V, { modelValue: n(v), "onUpdate:modelValue": t[5] || (t[5] = (s) => Q(v) ? v.value = s : null), "before-close": n(S), title: p.title, "wrapper-closable": false, "append-to-body": "", size: "100%", onClose: O }, { content: w(() => [m("div", le, [m("div", ne, [y(d, null, { header: w(() => [m("div", ae, [m("span", null, [t[6] || (t[6] = m("b", null, "单体", -1)), $("  " + F(I.currentRow.monomerName), 1)])])]), default: w(() => [y(o, { modelValue: n(l).query.productType, "onUpdate:modelValue": t[0] || (t[0] = (s) => n(l).query.productType = s), options: n(f).ENUM, class: "box-container", type: "enum" }, null, 8, ["modelValue", "options"]), n(l).query.productType === n(f).MACHINE_PART.V ? (C(), R(o, { key: 0, modelValue: n(l).query.steelPlateTypeEnum, "onUpdate:modelValue": t[1] || (t[1] = (s) => n(l).query.steelPlateTypeEnum = s), options: n(te).ENUM, class: "filter-item box-container", showOptionAll: "", type: "enum" }, null, 8, ["modelValue", "options"])) : z("", true), y(a, { modelValue: T.value, "onUpdate:modelValue": t[2] || (t[2] = (s) => T.value = s), modelModifiers: { trim: true }, class: "box-container", clearable: "", placeholder: "区域 / 批次", onInput: L }, null, 8, ["modelValue"]), y(r, { ref_key: "treeRef", ref: h, modelValue: n(l).query.areaId, "onUpdate:modelValue": t[3] || (t[3] = (s) => n(l).query.areaId = s), data: g.value, "expand-on-click-node": false, "filter-node-method": M, props: k, "render-content": D, "check-on-click-node": "", class: "filter-tree", "default-expand-all": "", "node-key": "id", onNodeClick: U }, null, 8, ["modelValue", "data"])]), _: 1 })]), m("div", re, [y(n(oe), { ref_key: "rightDetailRef", ref: u, "current-row": p.currentRow, permission: p.permission, onSuccess: t[4] || (t[4] = (s) => b("success")) }, null, 8, ["current-row", "permission"])])])]), _: 1 }, 8, ["modelValue", "before-close", "title"]);
  };
} }, ve = K(se, [["__scopeId", "data-v-01b43336"]]);
export {
  ve as default
};
