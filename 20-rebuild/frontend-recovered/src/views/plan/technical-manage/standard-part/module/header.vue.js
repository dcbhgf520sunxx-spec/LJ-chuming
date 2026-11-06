import { ref as u } from "vue";
import { computed as N } from "vue";
import { watch as g } from "vue";
import { resolveComponent as P } from "vue";
import { resolveDirective as _ } from "vue";
import { openBlock as y } from "vue";
import { createElementBlock as R } from "vue";
import { withDirectives as h } from "vue";
import { vShow as D } from "vue";
import { unref as e } from "vue";
import { createElementVNode as C } from "vue";
import { createVNode as r } from "vue";
import { normalizeStyle as q } from "vue";
import { withCtx as m } from "vue";
import { createBlock as k } from "vue";
import { createCommentVNode as L } from "vue";
import { createTextVNode as b } from "vue";
import { toDisplayString as M } from "vue";
import { ElInput as O } from "element-plus";
import { ElTag as $ } from "element-plus";
import { g as G, s as W, b as F, d as H } from "../../../../../modules/standard-part-8c26f414.js";
import { tw as K, B as J, kC as X, q as Y, tN as Z, ky as ee, tO as ae, C as te, G as le, L as w, E as oe } from "../../../../../shared/runtime.js";
import { _ as ne } from "../../../../../modules/ExcelUploadBtn-acccae97.js";
import { a as re } from "../../../../../modules/index-8356a01a.js";
const pe = { __name: "header", props: { projectId: { type: [Number, String], default: void 0 } }, emits: ["currentChange", "currentAreaChange"], setup(S, { emit: U }) {
  const E = { monomerId: { value: void 0, resetAble: false }, areaId: { value: void 0, resetAble: false }, projectId: { value: void 0, resetAble: false }, name: void 0, specification: void 0, remark: void 0, permissionCheck: K.CHECK_PERMISSION.V, areaBatchId: void 0, boolArtifactImport: void 0, useProperty: void 0, boolInbound: void 0 }, x = u(), d = u([]), p = u({}), I = U, i = u([]), { crud: n, query: t } = J(E), f = S, v = u(), A = N(() => {
    const o = {};
    for (const a in t) t[a] && (o[a] = t[a]);
    return o;
  });
  g(() => f.projectId, (o) => {
    o && (n.query.projectId = f.projectId, t.monomerId = void 0, t.areaId = void 0, i.value = [], d.value = [], t.areaBatchId = void 0, j(o), n.toQuery());
  }, { immediate: true, deep: true }), g([() => t.areaId, () => i.value], (o) => {
    var a;
    o && (i.value.length > 0 ? (d.value = (a = i.value.filter((s) => t.areaId === s.id)[0]) == null ? void 0 : a.planAreaBatchDTOS, p.value = { id: d.value ? d.value[0].id + "" : "", name: d.value ? d.value[0].name : "" }) : (p.value = {}, d.value = []));
  }, { immediate: true, deep: true });
  function B(o) {
    I("currentChange", o), n.toQuery();
  }
  function V(o) {
    o || (d.value = [], t.areaBatchId = void 0);
    const a = i.value.find((s) => s.id === o) || {};
    I("currentAreaChange", a), n.toQuery();
  }
  function T(o) {
    var a;
    i.value = o, t.areaId = (a = i.value[0]) == null ? void 0 : a.id, V(t.areaId);
  }
  async function j(o) {
    try {
      v.value = await G({ projectId: o });
    } catch (a) {
      console.log("查询项目是否关联物料", a);
    }
  }
  return (o, a) => {
    const s = P("common-select"), c = O, Q = $, z = _("permission");
    return y(), R("div", null, [h(C("div", null, [r(e(Y), { ref_key: "monomerSelectRef", ref: x, modelValue: e(t).monomerId, "onUpdate:modelValue": a[0] || (a[0] = (l) => e(t).monomerId = l), default: false, "main-product-type": e(X).STRUCTURE.V, "project-id": f.projectId, class: "filter-item", clearable: "", onChange: e(n).toQuery, onGetAreaInfo: T, onGetCurrentInfo: B }, null, 8, ["modelValue", "main-product-type", "project-id", "onChange"]), r(s, { modelValue: e(t).areaId, "onUpdate:modelValue": a[1] || (a[1] = (l) => e(t).areaId = l), dataStructure: { key: "id", label: "name", value: "id" }, options: i.value, class: "filter-item", clearable: "", placeholder: "请选择区域", size: "small", style: { width: "200px" }, type: "other", onChange: V }, null, 8, ["modelValue", "options"]), r(e(re), { modelValue: e(t).areaBatchId, "onUpdate:modelValue": a[2] || (a[2] = (l) => e(t).areaBatchId = l), "area-info": d.value, "default-tab": p.value, style: q(i.value.length > 0 ? "width:calc(100% - 430px)" : "width:calc(100% - 580px)"), class: "filter-item", onTabClick: e(n).toQuery }, null, 8, ["modelValue", "area-info", "default-tab", "style", "onTabClick"]), C("div", null, [r(s, { modelValue: e(t).boolArtifactImport, "onUpdate:modelValue": a[3] || (a[3] = (l) => e(t).boolArtifactImport = l), options: e(Z).ENUM, type: "enum", clearable: "", size: "default", placeholder: "全部来源", class: "filter-item", style: { width: "200px" }, onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), r(s, { modelValue: e(t).useProperty, "onUpdate:modelValue": a[4] || (a[4] = (l) => e(t).useProperty = l), options: e(ee).ENUM, type: "enum", clearable: "", size: "default", placeholder: "使用范围", class: "filter-item", style: { width: "200px" }, onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), r(s, { modelValue: e(t).boolInbound, "onUpdate:modelValue": a[5] || (a[5] = (l) => e(t).boolInbound = l), options: e(ae).ENUM, type: "enum", clearable: "", size: "default", placeholder: "全部状态", class: "filter-item", style: { width: "200px" }, onChange: e(n).toQuery }, null, 8, ["modelValue", "options", "onChange"]), r(c, { modelValue: e(t).name, "onUpdate:modelValue": a[6] || (a[6] = (l) => e(t).name = l), size: "default", placeholder: "名称", class: "filter-item", clearable: "", style: { width: "170px", "margin-left": "0" } }, null, 8, ["modelValue"]), r(c, { modelValue: e(t).specification, "onUpdate:modelValue": a[7] || (a[7] = (l) => e(t).specification = l), size: "default", placeholder: "规格", class: "filter-item", clearable: "", style: { width: "170px" } }, null, 8, ["modelValue"]), r(c, { modelValue: e(t).remark, "onUpdate:modelValue": a[8] || (a[8] = (l) => e(t).remark = l), size: "default", placeholder: "备注", class: "filter-item", clearable: "", style: { width: "170px" } }, null, 8, ["modelValue"]), r(e(te))])], 512), [[D, e(n).searchToggle]]), r(e(oe), { disabled: !e(t).areaId }, { optRight: m(() => [e(n).query.projectId && e(le)(e(n).permission.import) ? (y(), k(e(ne), { key: 0, data: A.value, disabled: !e(t).areaId, "upload-fun": e(W), "btn-name": "清单导入", "btn-size": "default", "btn-type": "primary", class: "filter-item", onSuccess: a[9] || (a[9] = (l) => e(n).toQuery()) }, null, 8, ["data", "disabled", "upload-fun"])) : L("", true), h((y(), k(w, { fn: e(F), class: "filter-item" }, { default: m(() => a[10] || (a[10] = [b(" 清单模板 ")])), _: 1, __: [10] }, 8, ["fn"])), [[z, e(n).permission.templateDownload]]), r(w, { disabled: !e(t).areaId, fn: e(H), params: { ...e(t), relationType: 2 }, class: "filter-item" }, { default: m(() => a[11] || (a[11] = [b(" 下载 ")])), _: 1, __: [11] }, 8, ["disabled", "fn", "params"])]), viewLeft: m(() => [r(Q, { class: "filter-item", effect: "plain", size: "large" }, { default: m(() => [b(" 当前配套件关联物料模式：" + M(v.value ? "关联物料领用" : "未关联物料领用"), 1)]), _: 1 })]), _: 1 }, 8, ["disabled"])]);
  };
} };
export {
  pe as default
};
