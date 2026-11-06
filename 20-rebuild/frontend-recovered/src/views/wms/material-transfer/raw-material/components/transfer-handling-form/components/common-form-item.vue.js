import { computed as i } from "vue";
import { ref as P } from "vue";
import { watchEffect as A } from "vue";
import { resolveComponent as T } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as N } from "vue";
import { createVNode as n } from "vue";
import { withCtx as s } from "vue";
import { unref as v } from "vue";
import { createBlock as c } from "vue";
import { createCommentVNode as f } from "vue";
import { createElementVNode as w } from "vue";
import { Fragment as O } from "vue";
import { ElFormItem as B } from "element-plus";
import { ElDatePicker as F } from "element-plus";
import { ElInput as W } from "element-plus";
import { _ as q, yW as D, yX as S, fg as $, b as V, x$ as u, i as _, fv as z, r8 as M, r9 as Q, yY as Y } from "../../../../../../../shared/runtime.js";
const J = { class: "flex-rsc", style: { width: "100%" } }, L = { __name: "common-form-item", props: { material: { type: Object }, form: { type: Object } }, setup(d) {
  const k = i(() => D()), { loaded: I, lastTime: y } = S();
  function h(t) {
    return _(y.value) && y.value.endTime ? t.getTime() < Number(y.value.endTime) + 1 * 1e3 || t.getTime() > (/* @__PURE__ */ new Date()).getTime() : t.getTime() > (/* @__PURE__ */ new Date()).getTime();
  }
  const o = d;
  $();
  const e = P({ transferType: void 0, projectId: void 0, monomerId: void 0, areaId: void 0, workshopId: void 0, warehouseId: void 0, quantity: void 0, remark: void 0 });
  A(() => {
    e.value = o.form, V(o.material.project) && (e.value.transferType = u.PROJECT_WARE.V);
  });
  const x = i(() => {
    var t, a, p;
    return _((t = o.material) == null ? void 0 : t.projectId) || _((a = o.material) == null ? void 0 : a.project) ? [o.material.projectId || ((p = o.material.project) == null ? void 0 : p.id)] : [];
  }), g = i(() => {
    let t = [];
    return o.material && o.material.boolPartyA ? t = [] : t = [u.RETURN_PARTY_A.V], V(o.material.project) && t.push(u.PUBLIC_WARE.V), t;
  }), E = i(() => e.value.transferType === u.PROJECT_WARE.V), b = i(() => e.value.transferType !== u.RETURN_PARTY_A.V);
  function j() {
    e.value.quantity = o.material.corOperableQuantity;
  }
  return (t, a) => {
    const p = T("common-radio"), r = B, C = T("common-input-number"), R = F, U = W;
    return m(), N(O, null, [n(r, { label: "类型", prop: "transferType" }, { default: s(() => [n(p, { modelValue: e.value.transferType, "onUpdate:modelValue": a[0] || (a[0] = (l) => e.value.transferType = l), "disabled-val": g.value, options: v(u).ENUM, size: "default", type: "enum" }, null, 8, ["modelValue", "disabled-val", "options"])]), _: 1 }), E.value ? (m(), c(r, { key: 0, label: "项目", prop: "projectId" }, { default: s(() => [n(z, { modelValue: e.value.projectId, "onUpdate:modelValue": a[1] || (a[1] = (l) => e.value.projectId = l), unshowOptions: x.value, clearable: "", style: { width: "100%" } }, null, 8, ["modelValue", "unshowOptions"])]), _: 1 })) : f("", true), b.value ? (m(), c(r, { key: 1, label: "仓库", prop: "workshopId" }, { default: s(() => [n(M, { modelValue: e.value.workshopId, "onUpdate:modelValue": a[2] || (a[2] = (l) => e.value.workshopId = l), placeholder: "仓库", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })) : f("", true), b.value ? (m(), c(r, { key: 2, label: "存储位置", prop: "warehouseId" }, { default: s(() => [n(Q, { modelValue: e.value.warehouseId, "onUpdate:modelValue": a[3] || (a[3] = (l) => e.value.warehouseId = l), "basic-class": d.material.basicClass, "workshop-id": e.value.workshopId, placeholder: "存储位置", style: { width: "100%" } }, null, 8, ["modelValue", "basic-class", "workshop-id"])]), _: 1 })) : f("", true), n(r, { label: `数量(${d.material.outboundUnit})`, prop: "quantity" }, { default: s(() => [w("div", J, [n(C, { modelValue: e.value.quantity, "onUpdate:modelValue": a[4] || (a[4] = (l) => e.value.quantity = l), max: d.material.corOperableQuantity, min: 0, precision: d.material.outboundUnitPrecision, "controls-position": "right", style: { flex: "auto" } }, null, 8, ["modelValue", "max", "precision"]), w("span", { class: "text-clickable set-max-text", style: { flex: "none" }, onClick: j }, "全部调拨")])]), _: 1 }, 8, ["label"]), k.value === v(Y).SELF.V ? (m(), c(r, { key: 3, label: "实际调拨时间", prop: "realTime" }, { default: s(() => [n(R, { modelValue: e.value.realTime, "onUpdate:modelValue": a[5] || (a[5] = (l) => e.value.realTime = l), type: "datetime", "value-format": "x", style: { width: "100%" }, disabled: !v(I), disabledDate: h, placeholder: "实际调拨时间" }, null, 8, ["modelValue", "disabled"])]), _: 1 })) : f("", true), n(r, { label: "备注", prop: "remark" }, { default: s(() => [n(U, { modelValue: e.value.remark, "onUpdate:modelValue": a[6] || (a[6] = (l) => e.value.remark = l), modelModifiers: { trim: true }, autosize: { minRows: 3, maxRows: 3 }, maxlength: "200", placeholder: "备注", "show-word-limit": "", style: { width: "100%" }, type: "textarea" }, null, 8, ["modelValue"])]), _: 1 })], 64);
  };
} }, H = q(L, [["__scopeId", "data-v-9c3f882b"]]);
export {
  H as default
};
