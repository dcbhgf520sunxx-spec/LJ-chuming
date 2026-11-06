import { m as N, o as V, q as g, r as j } from "../../../shared/runtime.js";
import { b } from "../../../modules/bim-model-view-dbf77a11.js";
import { ref as r } from "vue";
import { computed as y } from "vue";
import { resolveComponent as k } from "vue";
import { openBlock as i } from "vue";
import { createElementBlock as M } from "vue";
import { createElementVNode as m } from "vue";
import { createVNode as u } from "vue";
import { unref as a } from "vue";
import { createBlock as B } from "vue";
import { createCommentVNode as G } from "vue";
import "../../../modules/bimfaceAPI-c2661893.js";
import "../../../modules/model-0ac957f7.js";
import "../../../modules/index-d6a37d29.js";
import "../../../modules/drawing-preview-fullscreen-dialog-60155503.js";
import "../../../modules/use-chart-59e4b63c.js";
import "../../../modules/index-18acf776.js";
const H = { class: "app-container" }, P = { class: "head-container", style: { "margin-bottom": "0px" } }, w = { class: "filter-container" }, A = { class: "filter-left-box" }, C = { __name: "index", setup(E) {
  const n = r(), { globalProjectId: p, globalProject: f } = N(["globalProjectId", "globalProject"]), o = r({}), { maxHeight: I } = V({}), v = y(() => {
    var e, t;
    return (t = (e = n.value) == null ? void 0 : e.getOption(o.value.monomerId)) == null ? void 0 : t.name;
  }), s = r([]), d = r();
  function _(e) {
    s.value = e || [];
  }
  function h({ bimConfig: e }) {
    d.value = e == null ? void 0 : e.importMode;
  }
  return (e, t) => {
    var c;
    const x = k("common-select");
    return i(), M("div", H, [m("div", P, [m("div", w, [m("div", A, [u(a(g), { ref_key: "monomerRef", ref: n, modelValue: o.value.monomerId, "onUpdate:modelValue": t[0] || (t[0] = (l) => o.value.monomerId = l), "project-id": a(p), default: "", placeholder: "可选择单体", class: "filter-item", style: { width: "200px" }, onGetAreaInfo: _, onGetCurrentInfo: h }, null, 8, ["modelValue", "project-id"]), d.value === a(j).INTEGRATION.V ? (i(), B(x, { key: 0, modelValue: o.value.areaId, "onUpdate:modelValue": t[1] || (t[1] = (l) => o.value.areaId = l), options: s.value, dataStructure: { key: "id", label: "name", value: "id" }, clearable: "", class: "filter-item", placeholder: "请选择区域", style: { width: "200px" } }, null, 8, ["modelValue", "options"])) : G("", true)])])]), u(a(b), { monomerId: o.value.monomerId, areaId: o.value.areaId, maxHeight: a(I), monomerName: v.value, projectName: (c = a(f)) == null ? void 0 : c.shortName }, null, 8, ["monomerId", "areaId", "maxHeight", "monomerName", "projectName"])]);
  };
} };
export {
  C as default
};
