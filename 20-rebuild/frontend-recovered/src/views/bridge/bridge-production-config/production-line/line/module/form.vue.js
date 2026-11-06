import { ref as f } from "vue";
import { computed as S } from "vue";
import { watchEffect as U } from "vue";
import { watch as P } from "vue";
import { resolveComponent as g } from "vue";
import { openBlock as w } from "vue";
import { createBlock as k } from "vue";
import { withCtx as n } from "vue";
import { createVNode as r } from "vue";
import { unref as e } from "vue";
import { createTextVNode as C } from "vue";
import { createCommentVNode as q } from "vue";
import { ElFormItem as F } from "element-plus";
import { ElInput as N } from "element-plus";
import { ElInputNumber as R } from "element-plus";
import { ElForm as z } from "element-plus";
import { l as s, _ as B, aU as M, ao as O, aV as j, aD as x } from "../../../../../../shared/runtime.js";
import { _ as D } from "../../../../../../modules/factory-select-b8d0a4ac.js";
function A(a) {
  return s({ url: "/api/mes/bridge/productionLine/page", method: "get", params: a });
}
function $(a) {
  return s({ url: "/api/mes/bridge/productionLine", method: "post", data: a });
}
function K(a) {
  return s({ url: "/api/mes/bridge/productionLine", method: "put", data: a });
}
function X(a) {
  return s({ url: "/api/mes/bridge/productionLine", method: "delete", data: { ids: a } });
}
function Z({ id: a, boolEnabledEnum: u }) {
  return s({ url: "/api/mes/bridge/productionLine/changeState", method: "put", data: { id: a, boolEnabledEnum: u } });
}
function G({ productType: a, productionLineTypeEnum: u }) {
  return s({ module: "bridge", url: "productionLine/type", method: "get", params: { productType: a, productionLineTypeEnum: u } });
}
const ee = { get: A, add: $, edit: K, del: X };
const H = { __name: "form", setup(a) {
  const u = f(), I = { id: void 0, factoryId: void 0, workshopId: void 0, productType: void 0, productionLineTypeEnum: M.TRADITION.V, targetProductionShow: void 0, targetProduction: void 0, name: "", sort: 1, remark: "" }, _ = f([]), p = f(false), { crud: i, form: t } = O(I, u), y = S(() => i.status.edit >= 1), v = { workshopId: [{ required: true, message: "请选择车间", trigger: "change" }], factoryId: [{ required: true, message: "请选择工厂", trigger: "change" }], productType: [{ required: true, message: "请选择产品类型", trigger: "change" }], productionLineTypeEnum: [{ required: true, message: "请选择生产线类型", trigger: "change" }], linkIdList: [{ required: true, message: "请选择", trigger: "change" }], sort: [{ required: true, message: "请填写排序值", trigger: "blur", type: "number" }], name: [{ required: true, message: "请填写生产线名称", trigger: "blur" }, { min: 1, max: 32, message: "长度在 1 到 32 个字符", trigger: "blur" }], targetProductionShow: [{ required: true, message: "请填写目标产量", trigger: "blur", type: "number" }], remark: [{ max: 500, message: "不能超过 500 个字符", trigger: "blur" }] };
  U(() => {
    t.targetProduction = t.targetProductionShow * 1e3;
  }), P(() => [t.productType], () => {
    t.productType && L();
  }, { immediate: true });
  async function L() {
    try {
      p.value = true;
      const { productionLineTypeEnum: m, productType: o } = t, c = await G({ productionLineTypeEnum: m, productType: o });
      _.value = c;
    } catch (m) {
      console.log("获取可生产类型配置信息", m);
    } finally {
      p.value = false;
    }
  }
  return (m, o) => {
    const c = g("common-button"), d = F, b = N, h = R, V = g("common-select"), T = z, E = g("common-dialog");
    return w(), k(E, { "append-to-body": "", "close-on-click-modal": false, "before-close": e(i).cancelCU, visible: e(i).status.cu > 0, title: e(i).status.title, width: "550px" }, { titleRight: n(() => [r(c, { loading: e(i).status.cu === 2, type: "primary", size: "default", onClick: e(i).submitCU }, { default: n(() => o[8] || (o[8] = [C("确认")])), _: 1, __: [8] }, 8, ["loading", "onClick"])]), default: n(() => [r(T, { ref_key: "formRef", ref: u, model: e(t), rules: v, size: "default", "label-width": "130px" }, { default: n(() => [r(d, { label: "工厂", prop: "factoryId" }, { default: n(() => [r(D, { disabled: y.value, modelValue: e(t).factoryId, "onUpdate:modelValue": o[0] || (o[0] = (l) => e(t).factoryId = l), placeholder: "请选择工厂", style: { width: "270px" } }, null, 8, ["disabled", "modelValue"])]), _: 1 }), r(d, { label: "车间", prop: "workshopId" }, { default: n(() => [r(e(j), { disabled: y.value, modelValue: e(t).workshopId, "onUpdate:modelValue": o[1] || (o[1] = (l) => e(t).workshopId = l), "factory-id": e(t).factoryId, placeholder: "请先选择车间", style: { width: "270px" } }, null, 8, ["disabled", "modelValue", "factory-id"])]), _: 1 }), r(d, { label: "生产线名称", prop: "name" }, { default: n(() => [r(b, { modelValue: e(t).name, "onUpdate:modelValue": o[2] || (o[2] = (l) => e(t).name = l), type: "text", placeholder: "请填写生产线名称", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), r(d, { label: "目标产量(吨/月)", prop: "targetProductionShow" }, { default: n(() => [r(h, { modelValue: e(t).targetProductionShow, "onUpdate:modelValue": o[3] || (o[3] = (l) => e(t).targetProductionShow = l), modelModifiers: { number: true }, min: 0, max: 999999999, "controls-position": "right", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), r(d, { label: "产品类型", prop: "productType" }, { default: n(() => [r(V, { dataStructure: { key: "K", label: "L", value: "V" }, modelValue: e(t).productType, "onUpdate:modelValue": o[4] || (o[4] = (l) => e(t).productType = l), options: e(x).ENUM, placeholder: "请选择产品类型", style: { width: "270px" } }, null, 8, ["modelValue", "options"])]), _: 1 }), e(t).productType & e(x).BOX.V ? (w(), k(d, { key: 0, label: "可生产产品种类", prop: "linkIdList" }, { default: n(() => [r(V, { dataStructure: { key: "id", label: "name", value: "id" }, modelValue: e(t).linkIdList, "onUpdate:modelValue": o[5] || (o[5] = (l) => e(t).linkIdList = l), options: _.value, loading: p.value, multiple: "", placeholder: "请选择可生产产品种类", style: { width: "270px" } }, null, 8, ["modelValue", "options", "loading"])]), _: 1 })) : q("", true), r(d, { label: "排序", prop: "sort" }, { default: n(() => [r(h, { modelValue: e(t).sort, "onUpdate:modelValue": o[6] || (o[6] = (l) => e(t).sort = l), modelModifiers: { number: true }, min: 1, max: 999, step: 1, "controls-position": "right", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), r(d, { label: "备注", prop: "remark" }, { default: n(() => [r(b, { modelValue: e(t).remark, "onUpdate:modelValue": o[7] || (o[7] = (l) => e(t).remark = l), type: "textarea", autosize: { minRows: 4, maxRows: 6 }, placeholder: "请填写备注", style: { width: "320px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "visible", "title"]);
  };
} }, J = B(H, [["__scopeId", "data-v-b7181515"]]), te = Object.freeze(Object.defineProperty({ __proto__: null, default: J }, Symbol.toStringTag, { value: "Module" }));
export {
  ee as c,
  Z as e,
  te as f,
  J as m
};
