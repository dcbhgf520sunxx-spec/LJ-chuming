import { inject as S } from "vue";
import { ref as r } from "vue";
import { onMounted as T } from "vue";
import { resolveComponent as _ } from "vue";
import { resolveDirective as U } from "vue";
import { openBlock as n } from "vue";
import { createBlock as l } from "vue";
import { withCtx as i } from "vue";
import { createElementVNode as C } from "vue";
import { createTextVNode as g } from "vue";
import { createCommentVNode as v } from "vue";
import { withDirectives as x } from "vue";
import { unref as b } from "vue";
import { createVNode as y } from "vue";
import { createElementBlock as q } from "vue";
import { toDisplayString as F } from "vue";
import { ElNotification as I } from "element-plus";
import { ElTableColumn as R } from "element-plus";
import { ElInput as G } from "element-plus";
import { ElCard as J } from "element-plus";
import { vLoading as K } from "element-plus";
import { g as O, j as P } from "../../../../../modules/base-6bc46ddf.js";
import { o as Q, V as W, aN as X } from "../../../../../shared/runtime.js";
const Y = { class: "clearfix" }, Z = { key: 1 }, oe = { __name: "car-model-config", setup(ee) {
  const k = S("permission"), { maxHeight: w } = Q({ extraBox: [".el-card__header"], wrapperBox: [".app-container", ".el-card__body"], minHeight: 300, extraHeight: 25 }), o = r(false), t = r([]), d = r([]), c = r(false), m = r(false);
  T(() => {
    M();
  });
  async function M() {
    c.value = true;
    try {
      const a = await O();
      t.value = a.carModels.map((e) => ({ name: e })), d.value = a.carModels.map((e) => ({ name: e }));
    } catch (a) {
      console.log("获取车型配置", a);
    } finally {
      c.value = false;
    }
  }
  function E(a) {
    a.name && /^[0-9\u4E00-\u9FA5\.]+$/.test(a.name) || (a.name = void 0);
  }
  function V() {
    t.value.length === 0 && h(), o.value = !o.value;
  }
  function B() {
    t.value = W(d.value), o.value = false;
  }
  function z(a) {
    t.value.splice(a, 1);
  }
  function h() {
    t.value.push({});
  }
  async function H() {
    m.value = true;
    try {
      const a = X(t.value.map((e) => e.name));
      await P({ carModels: a }), I({ title: "车型配置成功", type: "success", duration: 2500 }), t.value = a.map((e) => ({ name: e })), d.value = a.map((e) => ({ name: e })), o.value = false;
    } catch (a) {
      console.log("设置车型配置", a);
    } finally {
      m.value = false;
    }
  }
  return (a, e) => {
    const N = _("common-tip-button"), u = _("common-button"), p = R, D = G, $ = _("common-table"), j = J, L = U("permission"), A = K;
    return n(), l(j, { shadow: "always" }, { header: i(() => [C("div", Y, [e[3] || (e[3] = C("span", { class: "card-title" }, "车型配置", -1)), o.value ? (n(), l(N, { key: 0, loading: m.value, "show-tip": "", size: "default", type: "primary", style: { float: "right" }, onClick: H }, { default: i(() => e[0] || (e[0] = [g(" 保存 ")])), _: 1, __: [0] }, 8, ["loading"])) : v("", true), o.value ? (n(), l(u, { key: 2, size: "default", type: "warning", style: { float: "right" }, onClick: B }, { default: i(() => e[2] || (e[2] = [g("取消编辑")])), _: 1, __: [2] })) : x((n(), l(u, { key: 1, size: "default", type: "primary", style: { float: "right" }, onClick: V }, { default: i(() => e[1] || (e[1] = [g("编辑")])), _: 1, __: [1] })), [[L, b(k).carModelConfigEdit]])])]), default: i(() => [x((n(), l($, { maxHeight: b(w) - 190, data: t.value, "return-source-data": "", "show-empty-symbol": false }, { default: i(() => [y(p, { label: "序号", type: "index", align: "center", width: "60" }), y(p, { prop: "name", label: "车型" }, { default: i((s) => [o.value ? (n(), l(D, { key: 0, modelValue: s.row.name, "onUpdate:modelValue": (f) => s.row.name = f, size: "default", maxlength: "50", placeholder: "车型", style: { width: "100%" }, onBlur: (f) => E(s.row) }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"])) : (n(), q("span", Z, F(s.row.name), 1))]), _: 1 }), o.value ? (n(), l(p, { key: 0, label: "操作", width: "100", align: "center" }, { default: i((s) => [s.$index === t.value.length - 1 ? (n(), l(u, { key: 0, size: "default", type: "primary", icon: "el-icon-plus", onClick: h, style: { padding: "6px" } })) : v("", true), y(u, { size: "default", type: "danger", icon: "el-icon-delete", onClick: (f) => z(s.$index), style: { padding: "6px" } }, null, 8, ["onClick"])]), _: 1 })) : v("", true)]), _: 1 }, 8, ["maxHeight", "data"])), [[A, c.value]])]), _: 1 });
  };
} };
export {
  oe as default
};
