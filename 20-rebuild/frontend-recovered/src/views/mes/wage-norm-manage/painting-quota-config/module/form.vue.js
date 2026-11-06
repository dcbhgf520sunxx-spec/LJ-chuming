import { ref as _ } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as g } from "vue";
import { createBlock as k } from "vue";
import { withCtx as s } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { createTextVNode as h } from "vue";
import { ElFormItem as V } from "element-plus";
import { ElInput as P } from "element-plus";
import { ElForm as F } from "element-plus";
import { ao as w, aV as y } from "../../../../../shared/runtime.js";
const I = { __name: "form", setup(x) {
  const n = _(), u = { workshopIdList: [], paintFilmThicknessBase: void 0, startAddPaintFilmThickness: void 0, startAddPrice: void 0, startPrice: void 0 }, { crud: a, form: r } = w(u, n), p = { workshopIdList: [{ required: true, message: "请选择车间", trigger: "change" }], paintFilmThicknessBase: [{ required: true, message: "请输入漆膜厚度基数", trigger: "blur" }], startAddPaintFilmThickness: [{ required: true, message: "请输入起加漆膜厚度", trigger: "blur" }], startAddPrice: [{ required: true, message: "请输入起加单价", trigger: "blur" }], startPrice: [{ required: true, message: "请输入起步单价", trigger: "blur" }] };
  return (T, t) => {
    const c = m("common-button"), i = V, d = P, f = F, b = m("common-dialog");
    return g(), k(b, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(a).cancelCU, visible: e(a).status.cu > 0, title: e(a).status.title, width: "520px" }, { titleRight: s(() => [l(c, { loading: e(a).status.cu === 2, type: "primary", size: "default", onClick: e(a).submitCU }, { default: s(() => t[5] || (t[5] = [h("确认")])), _: 1, __: [5] }, 8, ["loading", "onClick"])]), default: s(() => [l(f, { ref_key: "formRef", ref: n, model: e(r), rules: p, size: "default", "label-width": "160px" }, { default: s(() => [l(i, { label: "适用车间：", prop: "workshopIdList" }, { default: s(() => [l(e(y), { modelValue: e(r).workshopIdList, "onUpdate:modelValue": t[0] || (t[0] = (o) => e(r).workshopIdList = o), placeholder: "请选择车间", style: { width: "270px" }, multiple: "", "collapse-tags": "", class: "filter-item", clearable: "" }, null, 8, ["modelValue"])]), _: 1 }), l(i, { label: "漆膜厚度基数(µm)：", prop: "paintFilmThicknessBase" }, { default: s(() => [l(d, { modelValue: e(r).paintFilmThicknessBase, "onUpdate:modelValue": t[1] || (t[1] = (o) => e(r).paintFilmThicknessBase = o), modelModifiers: { number: true }, type: "number", placeholder: "单位：um", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), l(i, { label: "起步单价(元)：", prop: "startPrice" }, { default: s(() => [l(d, { modelValue: e(r).startPrice, "onUpdate:modelValue": t[2] || (t[2] = (o) => e(r).startPrice = o), modelModifiers: { number: true }, type: "number", placeholder: "单位：元", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), l(i, { label: "起加漆膜厚度(µm)：", prop: "startAddPaintFilmThickness" }, { default: s(() => [l(d, { modelValue: e(r).startAddPaintFilmThickness, "onUpdate:modelValue": t[3] || (t[3] = (o) => e(r).startAddPaintFilmThickness = o), modelModifiers: { number: true }, type: "number", placeholder: "单位：um", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), l(i, { label: "起加单价(元)：", prop: "startAddPrice" }, { default: s(() => [l(d, { modelValue: e(r).startAddPrice, "onUpdate:modelValue": t[4] || (t[4] = (o) => e(r).startAddPrice = o), modelModifiers: { number: true }, type: "number", placeholder: "单位：元", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} };
export {
  I as default
};
