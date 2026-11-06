import { ref as p } from "vue";
import { resolveComponent as m } from "vue";
import { openBlock as x } from "vue";
import { createBlock as S } from "vue";
import { withCtx as a } from "vue";
import { createVNode as l } from "vue";
import { unref as e } from "vue";
import { createTextVNode as V } from "vue";
import { ElInput as k } from "element-plus";
import { ElFormItem as C } from "element-plus";
import { ElForm as U } from "element-plus";
import { _ as v, ao as E, am as c } from "../../../../../shared/runtime.js";
const F = { __name: "form", setup(I) {
  const _ = { id: void 0, name: void 0, materialType: [], sort: void 0 }, f = p({ name: [{ required: true, max: 20, message: "不能超过20个字符", trigger: "blur" }], materialType: [{ required: true, message: "请选择仓库存储的材料类型", trigger: "change" }] }), d = p(), { CRUD: u, crud: o, form: s } = E(_, d);
  return o.submitFormFormat = (r) => (r.workshopId = o.query.workshopId, r.warehouseType = o.query.warehouseType, r), (r, t) => {
    const b = m("common-button"), y = k, i = C, g = m("common-select"), w = m("common-input-number"), h = U, T = m("common-dialog");
    return x(), S(T, { "append-to-body": "", "close-on-click-modal": false, visible: e(o).status.cu > e(u).STATUS.NORMAL, "before-close": e(o).cancelCU, title: `${e(o).props.workshop ? e(o).props.workshop.name + "：" : ""}${e(o).status.title}`, "show-close": true, "custom-class": "config-wms-warehouse-form", width: "600px" }, { titleRight: a(() => [l(b, { loading: e(o).status.cu === e(u).STATUS.PROCESSING, size: "default", type: "primary", onClick: e(o).submitCU }, { default: a(() => t[3] || (t[3] = [V(" 确认 ")])), _: 1, __: [3] }, 8, ["loading", "onClick"])]), default: a(() => [l(h, { ref_key: "formRef", ref: d, model: e(s), rules: f.value, disabled: e(o).status.cu === e(u).STATUS.PROCESSING, "label-position": "right", size: "default", "label-width": "150px" }, { default: a(() => [l(i, { label: "仓库位置", prop: "name" }, { default: a(() => [l(y, { modelValue: e(s).name, "onUpdate:modelValue": t[0] || (t[0] = (n) => e(s).name = n), modelModifiers: { trim: true }, type: "text", clearable: "", placeholder: "仓库位置", size: "default", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 }), l(i, { label: "可存储材料类型", prop: "materialType" }, { default: a(() => [l(g, { modelValue: e(s).materialType, "onUpdate:modelValue": t[1] || (t[1] = (n) => e(s).materialType = n), options: e(c).ENUM, unshowOptions: [e(c).GAS.K], multiple: "", mode: "bit", type: "enum", placeholder: "可存储材料类型", style: { width: "100%" } }, null, 8, ["modelValue", "options", "unshowOptions"])]), _: 1 }), l(i, { label: "排序", prop: "sort" }, { default: a(() => [l(w, { modelValue: e(s).sort, "onUpdate:modelValue": t[2] || (t[2] = (n) => e(s).sort = n), "controls-position": "right", class: "align-left", max: 99999, size: "default", placeholder: "排序", style: { width: "100%" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model", "rules", "disabled"])]), _: 1 }, 8, ["visible", "before-close", "title"]);
  };
} }, z = v(F, [["__scopeId", "data-v-7562e824"]]);
export {
  z as default
};
