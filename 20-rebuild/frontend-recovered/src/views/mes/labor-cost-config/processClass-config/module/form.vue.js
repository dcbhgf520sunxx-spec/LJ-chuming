import { ref as u } from "vue";
import { watch as C } from "vue";
import { resolveComponent as p } from "vue";
import { openBlock as v } from "vue";
import { createBlock as U } from "vue";
import { withCtx as l } from "vue";
import { createVNode as s } from "vue";
import { unref as e } from "vue";
import { createTextVNode as O } from "vue";
import { ElInput as w } from "element-plus";
import { ElFormItem as h } from "element-plus";
import { ElForm as k } from "element-plus";
import { ao as N, eu as b, es as S } from "../../../../../shared/runtime.js";
import { u as z } from "../../../../../modules/use-section-all-504a2069.js";
const A = { __name: "form", setup(R) {
  const c = u(), f = u([]), _ = u([]), { artifactSectionAll: m } = z(), I = { classification: "", artifactType: "", nameListIds: "", typeListIds: "" }, { crud: n, form: o, CRUD: y } = N(I, c), L = { classification: [{ required: true, message: "输入构件类型名称", trigger: "change" }], artifactType: [{ required: true, message: "选择主次构件", trigger: "change" }], nameListIds: [{ required: true, message: "选择构件名称", trigger: "change" }], typeListIds: [{ required: true, message: "选择截面类型", trigger: "change" }] };
  C(m, () => {
    f.value = m.value[b.SECTION_TYPE_ENUM.V][0].sectionWarehouseConfigDTOList;
  }), y.HOOK.beforeToEdit = (a, t) => {
    t.artifactType = a.form.artifactType, g();
  }, y.HOOK.beforeSubmit = (a) => {
    a.form.nameIndexList = a.form.nameListIds, a.form.typeIndexList = a.form.typeListIds;
  };
  const g = () => {
    var a;
    _.value = (a = m.value[b.PRODUCT_TYPE_ENUM.V]) == null ? void 0 : a.filter((t) => t.productClassificationEnum === o.artifactType)[0].sectionWarehouseConfigDTOList;
  };
  return (a, t) => {
    const T = p("common-button"), V = w, r = h, d = p("common-select"), E = k, x = p("common-dialog");
    return v(), U(x, { "close-on-click-modal": false, "before-close": e(n).cancelCU, visible: e(n).status.cu > 0, title: e(n).status.title, width: "500px" }, { titleRight: l(() => [s(T, { loading: e(n).status.cu === 2, type: "primary", size: "default", onClick: e(n).submitCU }, { default: l(() => t[4] || (t[4] = [O("确认")])), _: 1, __: [4] }, 8, ["loading", "onClick"])]), default: l(() => [s(E, { ref_key: "formRef", ref: c, model: e(o), rules: L, size: "default", "label-width": "100px" }, { default: l(() => [s(r, { label: "构件分类", prop: "classification" }, { default: l(() => [s(V, { modelValue: e(o).classification, "onUpdate:modelValue": t[0] || (t[0] = (i) => e(o).classification = i), placeholder: "输入构件类型名称", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), s(r, { label: "主次构件", prop: "artifactType" }, { default: l(() => [s(d, { modelValue: e(o).artifactType, "onUpdate:modelValue": t[1] || (t[1] = (i) => e(o).artifactType = i), options: e(S).ENUM, dataStructure: { key: "V", label: "L", value: "V" }, disabled: a.isEdit, size: "default", style: { width: "270px" }, onChange: g }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 }), s(r, { label: "清单构件名称索引", prop: "nameListIds" }, { default: l(() => [s(d, { modelValue: e(o).nameListIds, "onUpdate:modelValue": t[2] || (t[2] = (i) => e(o).nameListIds = i), options: _.value, disabled: e(o).artifactType === "", size: "default", multiple: true, style: { width: "270px" } }, null, 8, ["modelValue", "options", "disabled"])]), _: 1 }), s(r, { label: "截面类型", prop: "typeListIds" }, { default: l(() => [s(d, { modelValue: e(o).typeListIds, "onUpdate:modelValue": t[3] || (t[3] = (i) => e(o).typeListIds = i), options: f.value, dataStructure: { key: "id", label: "name", value: "id" }, size: "default", multiple: true, style: { width: "270px" } }, null, 8, ["modelValue", "options"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  A as default
};
