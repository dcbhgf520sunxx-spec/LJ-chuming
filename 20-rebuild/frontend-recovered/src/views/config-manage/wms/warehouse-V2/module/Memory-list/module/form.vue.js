import { ref as r } from "vue";
import { watchEffect as F } from "vue";
import { watch as I } from "vue";
import { onMounted as O } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as M } from "vue";
import { createBlock as N } from "vue";
import { withCtx as a } from "vue";
import { createVNode as s } from "vue";
import { unref as o } from "vue";
import { createTextVNode as R } from "vue";
import { ElInput as z } from "element-plus";
import { ElFormItem as P } from "element-plus";
import { ElInputNumber as S } from "element-plus";
import { ElForm as q } from "element-plus";
import { _ as A, ao as B, cP as y, a3 as K, gI as D } from "../../../../../../../shared/runtime.js";
import { p as H, g as W } from "../../../../../../../modules/production-line-c52339bd.js";
const j = { __name: "form", setup(X) {
  const d = r(), b = { id: void 0, name: void 0, workshopId: void 0, workshopUsers: void 0, materialType: void 0, sort: 1 }, p = r([]), h = r([]), f = r(false), { crud: l, CRUD: _, form: e } = B(b, d), w = r([]), E = r([y.AUX_MANUFACTURED.K]), x = { name: [{ required: true, message: "请填写或选择仓库名称", trigger: "blur" }, { min: 1, max: 32, message: "长度在 1 到 32 个字符", trigger: "blur" }], materialType: [{ required: true, message: "请选择材料类型", trigger: "change" }], sort: [{ required: true, message: "请填写排序值", trigger: "blur", type: "number" }] };
  F(() => {
    e.targetProduction = e.targetProductionShow * 1e3;
  }), I(() => [e.productType, e.productionLineTypeEnum], () => {
    e.productType && !(e.productType & K.ENCLOSURE.V) && T();
  }, { immediate: true }), O(() => {
    g(), v();
  });
  async function v() {
    const t = await D();
    w.value = t.content;
  }
  async function T() {
    try {
      f.value = true;
      const { productionLineTypeEnum: t, productType: n } = e, i = await H({ productionLineTypeEnum: t, productType: n });
      h.value = i;
    } catch (t) {
      console.log("获取存储位置信息", t);
    } finally {
      f.value = false;
    }
  }
  async function g() {
    p.value = [];
    try {
      const t = await W({});
      t == null || t.forEach((n) => {
        p.value.push({ name: n });
      });
    } catch (t) {
      console.log("获取所有存储位置失败", t);
    }
  }
  return _.HOOK.beforeSubmit = async () => {
  }, _.HOOK.afterSubmit = async () => {
    g();
  }, (t, n) => {
    const i = c("common-button"), U = z, m = P, V = c("common-select"), C = S, L = q, k = c("common-dialog");
    return M(), N(k, { "before-close": o(l).cancelCU, "close-on-click-modal": false, title: o(l).status.title, visible: o(l).status.cu > 0, "append-to-body": "", width: "550px" }, { titleRight: a(() => [s(i, { loading: o(l).status.cu === 2, size: "default", type: "primary", onClick: o(l).submitCU }, { default: a(() => n[3] || (n[3] = [R(" 确认 ")])), _: 1, __: [3] }, 8, ["loading", "onClick"])]), default: a(() => [s(L, { ref_key: "formRef", ref: d, model: o(e), rules: x, "label-width": "130px", size: "default" }, { default: a(() => [s(m, { label: "存储位置名称", prop: "name" }, { default: a(() => [s(U, { modelValue: o(e).name, "onUpdate:modelValue": n[0] || (n[0] = (u) => o(e).name = u), modelModifiers: { trim: true }, placeholder: "存储位置名称", size: "default", style: { width: "270px" }, type: "text" }, null, 8, ["modelValue"])]), _: 1 }), s(m, { label: "可存储材料类型", prop: "materialType" }, { default: a(() => [s(V, { modelValue: o(e).materialType, "onUpdate:modelValue": n[1] || (n[1] = (u) => o(e).materialType = u), multiple: true, options: o(y).ENUM, unshowOptions: E.value, showExtra: false, mode: "bit", placeholder: "请选择可存储材料类型", size: "default", style: { width: "270px" }, type: "enum" }, null, 8, ["modelValue", "options", "unshowOptions"])]), _: 1 }), s(m, { label: "排序", prop: "sort" }, { default: a(() => [s(C, { modelValue: o(e).sort, "onUpdate:modelValue": n[2] || (n[2] = (u) => o(e).sort = u), modelModifiers: { number: true }, max: 999, min: 1, step: 1, "controls-position": "right", style: { width: "270px" } }, null, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model"])]), _: 1 }, 8, ["before-close", "title", "visible"]);
  };
} }, Y = A(j, [["__scopeId", "data-v-870f21d7"]]);
export {
  Y as default
};
