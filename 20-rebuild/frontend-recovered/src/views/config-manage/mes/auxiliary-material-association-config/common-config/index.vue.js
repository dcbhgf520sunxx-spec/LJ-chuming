import { ref as u } from "vue";
import { computed as f } from "vue";
import { onMounted as j } from "vue";
import { resolveComponent as q } from "vue";
import { resolveDirective as F } from "vue";
import { openBlock as n } from "vue";
import { createElementBlock as v } from "vue";
import { createVNode as t } from "vue";
import { withCtx as a } from "vue";
import { unref as p } from "vue";
import { createBlock as c } from "vue";
import { createElementVNode as s } from "vue";
import { withDirectives as b } from "vue";
import { createTextVNode as _ } from "vue";
import { ElNotification as I } from "element-plus";
import { ElRadio as M } from "element-plus";
import { ElRadioGroup as S } from "element-plus";
import { ElFormItem as A } from "element-plus";
import { ElForm as O } from "element-plus";
import { ElCard as P } from "element-plus";
import { ElTag as U } from "element-plus";
import { ElCol as H } from "element-plus";
import { ElRow as J } from "element-plus";
import { vLoading as K } from "element-plus";
import { g as Q, a as W } from "../../../../../modules/project-config-5f01cdbc.js";
import { _ as X, d as Y, G as Z, ff as g, V as $ } from "../../../../../shared/runtime.js";
const h = { class: "clearfix" }, ee = { key: 1 }, oe = { __name: "index", setup(ae) {
  const i = u({ boolLink: void 0 }), r = u(false), d = u(false), l = u(i.value), y = f(() => Y(l.value, i.value)), k = f(() => r.value || d.value);
  j(() => {
    x();
  });
  async function x() {
    r.value = true;
    try {
      const o = await Q({ boolGeneralConfig: true }) || {};
      l.value = { boolLink: o == null ? void 0 : o.boolLink }, i.value = { boolLink: o == null ? void 0 : o.boolLink };
    } catch (o) {
      console.log("配套件关联物料配置", o);
    } finally {
      r.value = false;
    }
  }
  async function w() {
    d.value = true;
    try {
      l.value.boolGeneralConfig = true, await W(l.value), I({ title: "配套件关联物料配置成功", type: "success", duration: 2500 }), i.value = $(l.value);
    } catch (o) {
      console.log("配套件关联物料配置", o);
    } finally {
      d.value = false;
    }
  }
  return (o, e) => {
    const E = q("common-tip-button"), m = M, L = S, C = A, V = O, B = P, D = U, G = H, N = J, R = F("permission"), z = K;
    return n(), v("div", null, [t(N, null, { default: a(() => [t(G, { span: 12 }, { default: a(() => [p(Z)(p(g).get) ? (n(), c(B, { key: 0, shadow: "always" }, { header: a(() => [s("div", h, [e[2] || (e[2] = s("span", { class: "card-title" }, "配套件关联物料配置", -1)), b((n(), c(E, { loading: d.value, disabled: y.value, "show-tip": "", size: "default", type: "primary", style: { float: "right" }, onClick: w }, { default: a(() => e[1] || (e[1] = [_(" 保存 ")])), _: 1, __: [1] }, 8, ["loading", "disabled"])), [[R, p(g).edit]])])]), default: a(() => [b((n(), c(V, { model: l.value, disabled: k.value, "label-width": "160px" }, { default: a(() => [t(C, { label: "配套件关联物料配置：", prop: "boolLink" }, { default: a(() => [t(L, { modelValue: l.value.boolLink, "onUpdate:modelValue": e[0] || (e[0] = (T) => l.value.boolLink = T) }, { default: a(() => [t(m, { value: true }, { default: a(() => e[3] || (e[3] = [_("关联物料领用")])), _: 1, __: [3] }), t(m, { value: false }, { default: a(() => e[4] || (e[4] = [_("不关联")])), _: 1, __: [4] })]), _: 1 }, 8, ["modelValue"])]), _: 1 })]), _: 1 }, 8, ["model", "disabled"])), [[z, r.value]]), e[5] || (e[5] = s("p", { class: "explain" }, "说明：", -1)), e[6] || (e[6] = s("p", { class: "explain" }, " 1、关联物料领用：表示配套件名称与物料科目名称做对照绑定，配套件清单导入后，会同步到物料模块中。仓管员可根据配套件数据进行物料出库办理操作。工地使用配套件的可打包量受该配套件对应物料的出库量控制。 ", -1)), e[7] || (e[7] = s("p", { class: "explain" }, " 2、不关联：表示配套件业务流程与物料模块不做关联，配套件名称与物料科目名称可不做对照关联。导入后即视为自动入库，工地使用的配套件可在发运模块直接进行打包发运操作。 ", -1)), e[8] || (e[8] = s("p", { class: "explain" }, "3、配置生效优先级：项目配置 > 通用配置 （当项目配置设置了与通用配置不同的模式，则优先项目配置生效）。", -1))]), _: 1, __: [5, 6, 7, 8] })) : (n(), v("div", ee, [t(D, { type: "warning", size: "large" }, { default: a(() => e[9] || (e[9] = [_(" *暂无权限")])), _: 1, __: [9] })]))]), _: 1 })]), _: 1 })]);
  };
} }, ie = X(oe, [["__scopeId", "data-v-6c4a8170"]]);
export {
  ie as default
};
