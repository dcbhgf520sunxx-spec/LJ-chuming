import { ref as c } from "vue";
import { computed as D } from "vue";
import { resolveComponent as O } from "vue";
import { resolveDirective as P } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as R } from "vue";
import { withDirectives as I } from "vue";
import { vShow as $ } from "vue";
import { unref as e } from "vue";
import { createElementVNode as G } from "vue";
import { createVNode as i } from "vue";
import { normalizeStyle as L } from "vue";
import { withCtx as f } from "vue";
import { createBlock as b } from "vue";
import { createCommentVNode as g } from "vue";
import { createTextVNode as x } from "vue";
import { ElInput as Q } from "element-plus";
import { ElPopconfirm as F } from "element-plus";
import { l as d, B as H, T as M, q as Y, C as J, G as h, L as T, E as K } from "../../../../../shared/runtime.js";
import { a as W } from "../../../../../modules/index-8356a01a.js";
import { _ as V } from "../../../../../modules/ExcelUploadBtn-acccae97.js";
function X(t) {
  return d({ url: "/api/bridge/tech-box", method: "get", params: t });
}
function Z(t) {
  return d({ url: "/api/bridge/tech-box", method: "put", data: t });
}
function ee(t) {
  return d({ url: "/api/bridge/tech-box", method: "delete", data: t });
}
function C(t) {
  return d({ url: "/api/bridge/tech-box/import", responseType: "blob", method: "post", headers: { "Content-Type": "multipart/form-data" }, data: t });
}
function ae(t) {
  return d({ url: "/api/bridge/tech-box/export", responseType: "blob", method: "get", params: t });
}
function te() {
  return d({ url: "/api/bridge/tech-box/template-export", responseType: "blob", method: "get" });
}
function se(t) {
  return d({ url: "/api/bridge/tech-element/listByBoxId", method: "get", params: t });
}
function le(t) {
  return d({ url: "/api/bridge/tech-box/clear-by-areaId", method: "delete", params: t });
}
const ue = { edit: Z, del: ee, get: X }, oe = { __name: "header", props: { projectId: { type: [Number, String], default: void 0 }, globalProject: { type: Object, default: () => {
} } }, setup(t) {
  const w = { serialNumber: void 0, specification: void 0, material: void 0, monomerId: { value: void 0, resetAble: false }, areaId: { value: void 0, resetAble: false } }, S = c(), o = c({}), s = c([]), _ = c({}), y = c(false), { crud: l, query: r, CRUD: B } = H(w), k = t, A = D(() => ({ ...l.query }));
  function N(u) {
    const { name: a, label: p } = u;
    o.value = { id: a, name: p }, v();
  }
  function j(u) {
    s.value = u || [], s.value.length > 0 ? _.value = { id: s.value[0].id + "", name: s.value[0].name } : _.value = {};
  }
  async function z() {
    y.value = true;
    try {
      await le({ areaId: l.query.areaId }), l.notify("操作成功", B.NOTIFICATION_TYPE.SUCCESS), v(), y.value = false;
    } catch (u) {
      console.log("清空分段单元", u), y.value = false;
    }
  }
  function v() {
    l.toQuery();
  }
  return (u, a) => {
    const p = Q, E = O("common-button"), U = F, q = P("permission");
    return m(), R("div", null, [I(G("div", null, [i(e(Y), { ref_key: "monomerSelectRef", ref: S, modelValue: e(r).monomerId, "onUpdate:modelValue": a[0] || (a[0] = (n) => e(r).monomerId = n), "project-id": k.projectId, class: "filter-item", productType: e(M).BRIDGE.V, "show-tips": s.value.length <= 0, onGetAreaInfo: j }, null, 8, ["modelValue", "project-id", "productType", "show-tips"]), i(e(W), { class: "filter-item", style: L(s.value.length > 0 ? "width:calc(100% - 230px)" : "width:calc(100% - 380px)"), modelValue: e(r).areaId, "onUpdate:modelValue": a[1] || (a[1] = (n) => e(r).areaId = n), "area-info": s.value, "default-tab": _.value, onTabClick: N }, null, 8, ["style", "modelValue", "area-info", "default-tab"]), i(p, { modelValue: e(r).serialNumber, "onUpdate:modelValue": a[2] || (a[2] = (n) => e(r).serialNumber = n), size: "default", placeholder: "输入编号搜索", style: { width: "170px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), i(p, { modelValue: e(r).specification, "onUpdate:modelValue": a[3] || (a[3] = (n) => e(r).specification = n), size: "default", placeholder: "输入规格搜索", style: { width: "170px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), i(p, { modelValue: e(r).material, "onUpdate:modelValue": a[4] || (a[4] = (n) => e(r).material = n), size: "default", placeholder: "输入材质搜索", style: { width: "170px" }, class: "filter-item", clearable: "" }, null, 8, ["modelValue"]), i(e(J))], 512), [[$, e(l).searchToggle]]), i(e(K), null, { optLeft: f(() => [o.value && o.value.id && e(h)(e(l).permission.import) ? (m(), b(e(V), { key: 0, data: { areaId: e(l).query.areaId, importType: 1 }, "upload-fun": e(C), "btn-name": "清单增量导入", "btn-type": "primary", "btn-size": "default", class: "filter-item", onSuccess: v }, null, 8, ["data", "upload-fun"])) : g("", true), o.value && o.value.id && e(h)(e(l).permission.import) ? (m(), b(e(V), { key: 1, data: { areaId: e(l).query.areaId, importType: 2 }, "upload-fun": e(C), "btn-name": "清单覆盖导入", "btn-type": "success", "btn-size": "default", class: "filter-item", onSuccess: v }, null, 8, ["data", "upload-fun"])) : g("", true), o.value && o.value.id && e(h)(e(l).permission.download) ? (m(), b(T, { key: 2, fn: e(ae), params: A.value, class: "filter-item", disabled: e(l).data.length === 0 }, { default: f(() => a[5] || (a[5] = [x(" 分段单元清单(按条件查询) ")])), _: 1, __: [5] }, 8, ["fn", "params", "disabled"])) : g("", true), I((m(), b(T, { fn: e(te), class: "filter-item" }, { default: f(() => a[6] || (a[6] = [x(" 分段单元清单模板 ")])), _: 1, __: [6] }, 8, ["fn"])), [[q, e(l).permission.templateDownload]]), o.value && o.value.id && e(h)(e(l).permission.del) ? (m(), b(U, { key: 3, title: `确认清空【${o.value.name}】下的【单元件清单】么?`, onConfirm: z }, { reference: f(() => [i(E, { type: "danger", size: "default", loading: y.value, class: "filter-item", disabled: e(l).data.length === 0 }, { default: f(() => a[7] || (a[7] = [x(" 一键清空(按区域) ")])), _: 1, __: [7] }, 8, ["loading", "disabled"])]), _: 1 }, 8, ["title"])) : g("", true)]), _: 1 })]);
  };
} }, me = Object.freeze(Object.defineProperty({ __proto__: null, default: oe }, Symbol.toStringTag, { value: "Module" }));
export {
  oe as _,
  se as b,
  ue as c,
  me as h
};
