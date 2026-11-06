import { ref as D } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as p } from "vue";
import { createBlock as c } from "vue";
import { withCtx as o } from "vue";
import { createVNode as i } from "vue";
import { unref as e } from "vue";
import { createTextVNode as v } from "vue";
import { createCommentVNode as b } from "vue";
import { ElInput as P } from "element-plus";
import { ElFormItem as R } from "element-plus";
import { ElInputNumber as W } from "element-plus";
import { ElForm as I } from "element-plus";
import { _ as L, ao as U, dn as f } from "../../../../../../shared/runtime.js";
const C = { __name: "form", props: { line: { type: Object, default: () => {
} } }, setup(s) {
  const g = D(), h = { id: void 0, label: void 0, sort: void 0, name: void 0, type: void 0, dictionaryDetail: { id: void 0, effectiveWidth: void 0, unfoldedWidth: void 0 } }, { crud: u, form: l } = U(h, g), a = s, E = { label: [{ validator: (V, t, n) => {
    const _ = /^[+]{0,1}(\d+)$/, d = /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,3}$/, m = /^(?!(0[0-9]{0,}$))[0-9]{1,}[.]{0,}[0-9]{0,2}$/;
    t || n(new Error("请填写字典标签")), ["brand", "mode", "plating", "yield_strength", "plate_type", "in_plating", "out_plating", "in_Steel_Plate_brand", "out_steel_plate_brand", "brand_core", "out_plate_shape", "in_plate_shape"].includes(a.line.name) && t.length > 20 && n(new Error("长度在 20 个字符以内")), ["model", "out_material", "in_material", "in_coating", "out_coating", "out_colour", "in_colour", "kind_core"].includes(a.line.name) && t.length > 10 && n(new Error("长度在 10 个字符以内")), ["effective_width", "out_effective_width", "in_effective_width"].includes(a.line.name) && !_.test(t) && n(new Error("请输入整数")), ["thickness", "out_thickness", "in_thickness"].includes(a.line.name) && !d.test(t) && n(new Error("请输入数字且最多保留3位小数")), ["unit_weight_core"].includes(a.line.name) && !m.test(t) && n(new Error("请输入数字且最多保留2位小数")), n();
  }, trigger: "blur" }], "dictionaryDetail.effectiveWidth": [{ required: true, message: "请输入有效宽度", trigger: "blur" }], "dictionaryDetail.unfoldedWidth": [{ required: true, message: "请输入展宽", trigger: "blur" }], sort: [{ required: true, message: "请输入排序", trigger: "blur", type: "number" }] };
  return (V, t) => {
    const n = y("common-button"), _ = P, d = R, m = W, x = I, w = y("common-dialog");
    return p(), c(w, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(u).cancelCU, visible: e(u).status.cu > 0, title: e(u).status.title, width: "500px" }, { titleRight: o(() => [i(n, { loading: e(u).status.cu === 2, type: "primary", size: "default", onClick: e(u).submitCU }, { default: o(() => t[4] || (t[4] = [v("确认")])), _: 1, __: [4] }, 8, ["loading", "onClick"])]), default: o(() => [i(x, { ref_key: "formRef", ref: g, model: e(l), rules: E, size: "default", "label-width": "120px" }, { default: o(() => [i(d, { label: "字典标签", prop: "label" }, { default: o(() => [i(_, { modelValue: e(l).label, "onUpdate:modelValue": t[0] || (t[0] = (r) => e(l).label = r), placeholder: "输入字典标签", class: "filter-item", style: { width: "200px" }, size: "default", clearable: "" }, null, 8, ["modelValue"])]), _: 1 }), (a.line.type === e(f).PROFILED_PLATE.V || s.line.type === e(f).PRESSURE_BEARING_PLATE.V) && s.line.name === "plate_type" ? (p(), c(d, { key: 0, label: "展宽(mm)", prop: "dictionaryDetail.unfoldedWidth" }, { default: o(() => [i(m, { class: "align-left", modelValue: e(l).dictionaryDetail.unfoldedWidth, "onUpdate:modelValue": t[1] || (t[1] = (r) => e(l).dictionaryDetail.unfoldedWidth = r), placeholder: "请填写", type: "text", "controls-position": "right", style: { width: "200px" }, min: 0, max: 999999999 }, null, 8, ["modelValue"])]), _: 1 })) : b("", true), (a.line.type === e(f).PROFILED_PLATE.V || s.line.type === e(f).PRESSURE_BEARING_PLATE.V) && s.line.name === "plate_type" ? (p(), c(d, { key: 1, label: "有效宽度(mm)", prop: "dictionaryDetail.effectiveWidth" }, { default: o(() => [i(m, { class: "align-left", modelValue: e(l).dictionaryDetail.effectiveWidth, "onUpdate:modelValue": t[2] || (t[2] = (r) => e(l).dictionaryDetail.effectiveWidth = r), placeholder: "请填写", type: "text", "controls-position": "right", style: { width: "200px" }, min: 0, max: 999999999 }, null, 8, ["modelValue"])]), _: 1 })) : b("", true), i(d, { label: "排序", prop: "sort" }, { default: o(() => [i(m, { class: "align-left", modelValue: e(l).sort, "onUpdate:modelValue": t[3] || (t[3] = (r) => e(l).sort = r), placeholder: "请填写", type: "text", "controls-position": "right", style: { width: "200px" }, min: 0, max: 1e3 }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, A = L(C, [["__scopeId", "data-v-21f78ea5"]]);
export {
  A as default
};
