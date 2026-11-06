import { ref as u } from "vue";
import { watchEffect as C } from "vue";
import { watch as L } from "vue";
import { onMounted as T } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as F } from "vue";
import { createBlock as S } from "vue";
import { withCtx as r } from "vue";
import { createVNode as s } from "vue";
import { unref as o } from "vue";
import { createTextVNode as W } from "vue";
import { ElInput as z } from "element-plus";
import { ElFormItem as M } from "element-plus";
import { ElInputNumber as N } from "element-plus";
import { ElForm as O } from "element-plus";
import { p as R, g as P } from "../../../../../../../modules/production-line-c52339bd.js";
import { _ as q, ao as B, a3 as H, aV as K, gI as j } from "../../../../../../../shared/runtime.js";
const D = { __name: "form", setup($) {
  const c = u(), h = { id: void 0, name: void 0, factoryId: void 0, workshopId: void 0, workshopUsers: void 0, mesWorkshopId: void 0, sort: 1 }, p = u([]), b = u([]), f = u(false), { crud: l, CRUD: _, form: e } = B(h, c), g = u([]), w = { name: [{ required: true, message: "请填写或选择仓库名称", trigger: "blur" }, { min: 1, max: 32, message: "长度在 1 到 32 个字符", trigger: "blur" }], workshopUsers: [{ required: true, message: "请选择仓库负责人", trigger: "change" }], sort: [{ required: true, message: "请填写排序值", trigger: "blur", type: "number" }] };
  C(() => {
    e.targetProduction = e.targetProductionShow * 1e3;
  }), L(() => [e.productType, e.productionLineTypeEnum], () => {
    e.productType && !(e.productType & H.ENCLOSURE.V) && v();
  }, { immediate: true });
  async function k() {
    const n = await j();
    g.value = n.content;
  }
  T(() => {
    y(), k();
  });
  async function v() {
    try {
      f.value = true;
      const { productionLineTypeEnum: n, productType: t } = e, m = await R({ productionLineTypeEnum: n, productType: t });
      b.value = m;
    } catch (n) {
      console.log("获取可生产类型配置信息", n);
    } finally {
      f.value = false;
    }
  }
  async function y() {
    p.value = [];
    try {
      const n = await P({});
      n == null || n.forEach((t) => {
        p.value.push({ name: t });
      });
    } catch (n) {
      console.log("获取所有仓库失败", n);
    }
  }
  return _.HOOK.beforeSubmit = async () => {
  }, _.HOOK.afterSubmit = async () => {
    y();
  }, (n, t) => {
    const m = d("common-button"), x = z, i = M, V = d("common-select-v2"), U = N, E = O, I = d("common-dialog");
    return F(), S(I, { "before-close": o(l).cancelCU, "close-on-click-modal": false, title: o(l).status.title, visible: o(l).status.cu > 0, "append-to-body": "", width: "550px" }, { titleRight: r(() => [s(m, { loading: o(l).status.cu === 2, size: "default", type: "primary", onClick: o(l).submitCU }, { default: r(() => t[4] || (t[4] = [W(" 确认 ")])), _: 1, __: [4] }, 8, ["loading", "onClick"])]), default: r(() => [s(E, { ref_key: "formRef", ref: c, model: o(e), rules: w, "label-width": "130px", size: "default" }, { default: r(() => [s(i, { label: "仓库名称", prop: "name" }, { default: r(() => [s(x, { modelValue: o(e).name, "onUpdate:modelValue": t[0] || (t[0] = (a) => o(e).name = a), modelModifiers: { trim: true }, placeholder: "仓库名称", size: "default", style: { width: "270px" }, type: "text" }, null, 8, ["modelValue"])]), _: 1 }), s(i, { label: "仓库组负责人", prop: "workshopUsers" }, { default: r(() => [s(V, { modelValue: o(e).workshopUsers, "onUpdate:modelValue": t[1] || (t[1] = (a) => o(e).workshopUsers = a), options: g.value, dataStructure: { value: "id", label: "name", key: "id" }, showExtra: false, filterable: "", multiple: "", placeholder: "请选择仓库负责人", size: "default", style: { width: "270px" }, type: "other" }, null, 8, ["modelValue", "options"])]), _: 1 }), s(i, { label: "关联MES车间", prop: "mesWorkshopId" }, { default: r(() => [s(o(K), { modelValue: o(e).mesWorkshopId, "onUpdate:modelValue": t[2] || (t[2] = (a) => o(e).mesWorkshopId = a), placeholder: "请先选择车间", multiple: "", collapseTags: "", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 }), s(i, { label: "排序", prop: "sort" }, { default: r(() => [s(U, { modelValue: o(e).sort, "onUpdate:modelValue": t[3] || (t[3] = (a) => o(e).sort = a), modelModifiers: { number: true }, max: 999, min: 1, step: 1, "controls-position": "right", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "title", "visible"]);
  };
} }, Q = q(D, [["__scopeId", "data-v-4a4c88c9"]]);
export {
  Q as default
};
