import { ref as f } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as L } from "vue";
import { createBlock as T } from "vue";
import { withCtx as n } from "vue";
import { createVNode as l } from "vue";
import { unref as t } from "vue";
import { createTextVNode as h } from "vue";
import { ElFormItem as w } from "element-plus";
import { ElInput as x } from "element-plus";
import { ElForm as C } from "element-plus";
import { g as B } from "../../../../../modules/paint-config-780a81bc.js";
import { ao as K, bY as G } from "../../../../../shared/runtime.js";
const S = { __name: "form", setup(R) {
  const b = { paintingTypeEnum: void 0, paintBrand: void 0, paintType: void 0, specificGravity: void 0, volumeSolidContent: void 0, packageWeight: void 0, unit: void 0, packageUnit: void 0 }, c = f(), { crud: u, form: o } = K(b, c);
  function s(d, e, p) {
    if (e === "" || e === void 0 || e === null) return p(new Error("请输入大于0的数值"));
    const i = Number(e);
    return Number.isNaN(i) || i <= 0 ? p(new Error("必须大于0")) : p();
  }
  const y = f([]), V = { paintingTypeEnum: [{ required: true, message: "请选择涂装类型", trigger: "change" }], paintBrand: [{ required: true, message: "请填写油漆品牌", trigger: "blur" }], paintType: [{ required: true, message: "请填写油漆类型", trigger: "blur" }], specificGravity: [{ required: true, message: "请填写比重", trigger: "blur" }, { validator: s, message: "比重不能小于0" }], volumeSolidContent: [{ required: true, message: "请填写体积固含量", trigger: "blur" }, { validator: s, message: "体积固含量不能小于0" }], packageWeight: [{ required: true, message: "请填写包装重量", trigger: "blur" }, { validator: s, message: "包装重量不能小于0" }], unit: [{ required: true, message: "请选择单位", trigger: "change" }], packageUnit: [{ required: true, message: "请选择包装单位", trigger: "change" }] };
  async function U() {
    try {
      const d = await B();
      y.value = d || [];
    } catch (d) {
      console.log(d);
    }
  }
  U();
  const _ = { KILOGRAM: { L: "kg", K: "KILOGRAM" }, LITRE: { L: "L", K: "LITRE" } }, k = { BUCKET: { L: "桶", K: "BUCKET" }, GROUP: { L: "组", K: "GROUP" } };
  return (d, e) => {
    const p = g("common-button"), i = g("common-select"), r = w, m = x, E = C, v = g("common-dialog");
    return L(), T(v, { "append-to-body": "", "close-on-click-modal": false, "before-close": t(u).cancelCU, visible: t(u).status.cu > 0, title: t(u).status.title, width: "550px" }, { titleRight: n(() => [l(p, { loading: t(u).status.cu === 2, type: "primary", onClick: t(u).submitCU }, { default: n(() => e[8] || (e[8] = [h("确认")])), _: 1, __: [8] }, 8, ["loading", "onClick"])]), default: n(() => [l(E, { ref_key: "formRef", ref: c, model: t(o), rules: V, "label-width": "120px" }, { default: n(() => [l(r, { label: "涂装类型：", prop: "paintingTypeEnum" }, { default: n(() => [l(i, { type: "enum", modelValue: t(o).paintingTypeEnum, "onUpdate:modelValue": e[0] || (e[0] = (a) => t(o).paintingTypeEnum = a), options: t(G).ENUM, clearable: "", placeholder: "选择涂装类型", style: { width: "270px" }, class: "filter-item" }, null, 8, ["modelValue", "options"])]), _: 1 }), l(r, { label: "油漆品牌：", prop: "paintBrand" }, { default: n(() => [l(m, { modelValue: t(o).paintBrand, "onUpdate:modelValue": e[1] || (e[1] = (a) => t(o).paintBrand = a), modelModifiers: { trim: true }, clearable: "", placeholder: "输入品牌", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), l(r, { label: "油漆类型：", prop: "paintType" }, { default: n(() => [l(m, { modelValue: t(o).paintType, "onUpdate:modelValue": e[2] || (e[2] = (a) => t(o).paintType = a), modelModifiers: { trim: true }, clearable: "", placeholder: "输入油漆材质", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), l(r, { label: "体积固含量(%)", prop: "volumeSolidContent" }, { default: n(() => [l(m, { modelValue: t(o).volumeSolidContent, "onUpdate:modelValue": e[3] || (e[3] = (a) => t(o).volumeSolidContent = a), modelModifiers: { number: true }, clearable: "", type: "number", placeholder: "输入体积固体份含量", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), l(r, { label: "单位", prop: "unit" }, { default: n(() => [l(i, { modelValue: t(o).unit, "onUpdate:modelValue": e[4] || (e[4] = (a) => t(o).unit = a), options: _, dataStructure: { key: "K", label: "L", value: "L" }, clearable: "", filterable: "", type: "other", placeholder: "kg或L", style: { width: "270px" }, class: "filter-item" }, null, 8, ["modelValue"])]), _: 1 }), l(r, { label: "比重（kg/L）", prop: "specificGravity" }, { default: n(() => [l(m, { modelValue: t(o).specificGravity, "onUpdate:modelValue": e[5] || (e[5] = (a) => t(o).specificGravity = a), modelModifiers: { number: true }, clearable: "", type: "number", placeholder: "如果容量单位需换算成重量单位", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), l(r, { label: "包装重量", prop: "packageWeight" }, { default: n(() => [l(m, { modelValue: t(o).packageWeight, "onUpdate:modelValue": e[6] || (e[6] = (a) => t(o).packageWeight = a), modelModifiers: { number: true }, clearable: "", type: "number", placeholder: "每桶或每组的重量", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), l(r, { label: "包装单位", prop: "packageUnit" }, { default: n(() => [l(i, { modelValue: t(o).packageUnit, "onUpdate:modelValue": e[7] || (e[7] = (a) => t(o).packageUnit = a), options: k, dataStructure: { key: "K", label: "L", value: "L" }, clearable: "", filterable: "", type: "other", placeholder: "桶或组", style: { width: "270px" }, class: "filter-item" }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  S as default
};
