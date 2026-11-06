import { inject as B } from "vue";
import { useStore as F } from "vuex";
import { ref as t } from "vue";
import { computed as g } from "vue";
import { onMounted as T } from "vue";
import { resolveComponent as w } from "vue";
import { resolveDirective as j } from "vue";
import { openBlock as n } from "vue";
import { createBlock as i } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as W } from "vue";
import { withDirectives as y } from "vue";
import { createTextVNode as c } from "vue";
import { unref as p } from "vue";
import { createVNode as r } from "vue";
import { ElRadioGroup as z } from "element-plus";
import { createCommentVNode as V } from "vue";
import { ElNotification as A } from "element-plus";
import { ElRadio as K } from "element-plus";
import { ElFormItem as G } from "element-plus";
import { ElForm as I } from "element-plus";
import { ElCard as O } from "element-plus";
import { vLoading as H } from "element-plus";
import { x as J, y as P } from "../../../../../modules/base-6bc46ddf.js";
import { n as Q, d as X, fm as Y, b as Z, V as $ } from "../../../../../shared/runtime.js";
const ee = { class: "clearfix" }, re = { __name: "mes-warehouse-manage", setup(oe) {
  const M = B("permission"), v = { TRUE: { L: "库位必选", K: "TRUE", V: true }, FALSE: { L: "库位非必选", K: "FALSE", V: false } };
  Q(v);
  const N = F(), _ = t(), d = t({ boolEnableWarehouse: void 0, warehouseNumberModeEnum: void 0, boolRequiredWarehouse: void 0 }), o = t(d.value), m = t(false), f = t(false), R = g(() => X(o.value, d.value)), q = g(() => m.value || f.value), x = { boolEnableWarehouse: [{ required: true, message: "请选择库位管理", trigger: "change" }], warehouseNumberModeEnum: [{ required: true, validator: (s, e, a) => {
    o.value.boolEnableWarehouse && !e && a(new Error("请选择选码方式")), a();
  }, trigger: "change" }], boolRequiredWarehouse: [{ required: true, validator: (s, e, a) => {
    o.value.boolEnableWarehouse && Z(e) && a(new Error("请选择入库库位选择")), a();
  }, trigger: "change" }] };
  T(() => {
    C();
  });
  async function C() {
    m.value = true;
    try {
      const { boolEnableWarehouse: s = false, warehouseNumberModeEnum: e = false, boolRequiredWarehouse: a = false } = await J();
      o.value = { boolEnableWarehouse: s, warehouseNumberModeEnum: e, boolRequiredWarehouse: a }, d.value = { boolEnableWarehouse: s, warehouseNumberModeEnum: e, boolRequiredWarehouse: a };
    } catch (s) {
      console.log("获取库位管理", s);
    } finally {
      m.value = false;
    }
  }
  async function L() {
    if (await _.value.validate()) {
      f.value = true;
      try {
        await P(o.value), A({ title: "库位管理成功", type: "success", duration: 2500 }), d.value = $(o.value), N.dispatch("config/fetchMesWarehouseConfig");
      } catch (e) {
        console.log("设置库位管理", e);
      } finally {
        f.value = false;
      }
    }
  }
  return (s, e) => {
    const a = w("common-tip-button"), E = K, b = G, h = w("common-radio"), U = I, D = O, S = j("permission"), k = H;
    return n(), i(D, { shadow: "always" }, { header: l(() => [W("div", ee, [e[4] || (e[4] = W("span", { class: "card-title" }, "库位管理", -1)), y((n(), i(a, { loading: f.value, disabled: R.value, "show-tip": "", size: "mini", type: "primary", style: { float: "right" }, onClick: L }, { default: l(() => e[3] || (e[3] = [c(" 保存 ")])), _: 1, __: [3] }, 8, ["loading", "disabled"])), [[S, p(M).mesWarehouseManageEdit]])])]), default: l(() => [y((n(), i(U, { ref_key: "formRef", ref: _, model: o.value, rules: x, disabled: q.value, "label-width": "120px" }, { default: l(() => [r(b, { label: "库位管理", prop: "boolEnableWarehouse" }, { default: l(() => [r(p(z), { modelValue: o.value.boolEnableWarehouse, "onUpdate:modelValue": e[0] || (e[0] = (u) => o.value.boolEnableWarehouse = u) }, { default: l(() => [r(E, { label: true }, { default: l(() => e[5] || (e[5] = [c("显示")])), _: 1, __: [5] }), r(E, { label: false }, { default: l(() => e[6] || (e[6] = [c("不显示")])), _: 1, __: [6] })]), _: 1 }, 8, ["modelValue"])]), _: 1 }), o.value.boolEnableWarehouse ? (n(), i(b, { key: 0, label: "选码方式", prop: "warehouseNumberModeEnum" }, { default: l(() => [r(h, { options: p(Y).ENUM, type: "enum", modelValue: o.value.warehouseNumberModeEnum, "onUpdate:modelValue": e[1] || (e[1] = (u) => o.value.warehouseNumberModeEnum = u) }, null, 8, ["options", "modelValue"])]), _: 1 })) : V("", true), o.value.boolEnableWarehouse ? (n(), i(b, { key: 1, label: "入库库位选择", prop: "boolRequiredWarehouse" }, { default: l(() => [r(h, { options: v.ENUM, type: "enum", modelValue: o.value.boolRequiredWarehouse, "onUpdate:modelValue": e[2] || (e[2] = (u) => o.value.boolRequiredWarehouse = u) }, null, 8, ["options", "modelValue"])]), _: 1 })) : V("", true)]), _: 1 }, 8, ["model", "disabled"])), [[k, m.value]])]), _: 1 });
  };
} };
export {
  re as default
};
