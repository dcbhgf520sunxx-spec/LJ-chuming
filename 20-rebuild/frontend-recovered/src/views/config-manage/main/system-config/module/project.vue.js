import { ref as _ } from "vue";
import { useStore as z } from "vuex";
import { computed as q } from "vue";
import { resolveComponent as I } from "vue";
import { resolveDirective as K } from "vue";
import { unref as o } from "vue";
import { openBlock as t } from "vue";
import { createBlock as f } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as A } from "vue";
import { createElementBlock as c } from "vue";
import { createVNode as i } from "vue";
import { createTextVNode as b } from "vue";
import { createCommentVNode as V } from "vue";
import { withDirectives as g } from "vue";
import { Fragment as G } from "vue";
import { renderList as J } from "vue";
import { toDisplayString as O } from "vue";
import { ElMessage as T } from "element-plus";
import { ElCheckbox as H } from "element-plus";
import { ElFormItem as Q } from "element-plus";
import { ElRadio as W } from "element-plus";
import { ElForm as X } from "element-plus";
import { ElCard as Y } from "element-plus";
import { vLoading as Z } from "element-plus";
import { _ as $, d as ee, G as d, eJ as ae, au as C, eK as F, eL as oe, eM as te } from "../../../../../shared/runtime.js";
const le = { key: 0, style: { float: "right" } }, se = { key: 1 }, ne = { key: 1 }, re = { key: 1 }, ue = { __name: "project", setup(ce) {
  const u = oe.project, j = { arrangement: void 0, showProjectFullName: void 0, showSerialNumber: void 0 }, S = _(), k = z(), h = _(false), p = _(false), e = _({ ...j }), v = _({ ...j }), x = q(() => !ee(e.value, v.value));
  E();
  async function E() {
    if (d(u.get)) {
      h.value = true;
      try {
        const { showProjectFullName: n, showSerialNumber: a, arrangement: m } = await ae() || {};
        v.value = { showProjectFullName: n, showSerialNumber: a, arrangement: m }, e.value = { showProjectFullName: n, showSerialNumber: a, arrangement: m };
      } catch (n) {
        console.log("error", n);
      } finally {
        h.value = false;
      }
    }
  }
  async function P() {
    p.value = true;
    try {
      await te(e.value), v.value = { ...e.value }, T.success("修改成功"), k.dispatch("settings/changeSetting", /* @__PURE__ */ new Map([["projectNameShowConfig", e.value]])), k.dispatch("project/fetchUserProjects");
    } catch (n) {
      console.log("设置基础信息：项目信息", n);
    } finally {
      p.value = false;
    }
  }
  function L() {
    e.value = { ...v.value };
  }
  return (n, a) => {
    const m = I("common-button"), N = H, y = Q, D = W, M = X, B = Y, w = K("empty-text"), U = Z;
    return o(d)(o(u).get) ? (t(), f(B, { key: 0, class: "box-card", shadow: "hover" }, { header: l(() => [a[5] || (a[5] = A("span", { class: "title" }, "项目信息配置", -1)), o(d)(o(u).edit) && x.value ? (t(), c("div", le, [i(m, { size: "default", type: "warning", onClick: L }, { default: l(() => a[3] || (a[3] = [b("取消修改")])), _: 1, __: [3] }), i(m, { loading: p.value, size: "default", type: "success", onClick: P }, { default: l(() => a[4] || (a[4] = [b("保存")])), _: 1, __: [4] }, 8, ["loading"])])) : V("", true)]), default: l(() => [g((t(), c("div", null, [i(M, { ref_key: "projectFormRef", ref: S, model: e.value }, { default: l(() => [i(y, { label: "是否在数据展示时显示项目全称(不勾选显示项目简称)", prop: "showProjectFullName" }, { default: l(() => {
      var s;
      return [o(d)(o(u).edit) ? (t(), f(N, { key: 0, modelValue: e.value.showProjectFullName, "onUpdate:modelValue": a[0] || (a[0] = (r) => e.value.showProjectFullName = r) }, null, 8, ["modelValue"])) : g((t(), c("span", se, null, 512)), [[w, (s = o(C)) == null ? void 0 : s.VL[e.value.showProjectFullName]]])];
    }), _: 1 }), i(y, { label: "是否在展示项目名称时显示合同编号", prop: "showSerialNumber" }, { default: l(() => {
      var s;
      return [o(d)(o(u).edit) ? (t(), f(N, { key: 0, modelValue: e.value.showSerialNumber, "onUpdate:modelValue": a[1] || (a[1] = (r) => e.value.showSerialNumber = r) }, null, 8, ["modelValue"])) : g((t(), c("span", ne, null, 512)), [[w, (s = o(C)) == null ? void 0 : s.VL[e.value.showSerialNumber]]])];
    }), _: 1 }), i(y, { label: "项目名称展示方式", prop: "arrangement" }, { default: l(() => {
      var s;
      return [o(d)(o(u).edit) ? (t(true), c(G, { key: 0 }, J(o(F).ENUM, (r) => (t(), f(D, { key: r.K, modelValue: e.value.arrangement, "onUpdate:modelValue": a[2] || (a[2] = (R) => e.value.arrangement = R), value: r.V }, { default: l(() => [b(O(r.L), 1)]), _: 2 }, 1032, ["modelValue", "value"]))), 128)) : g((t(), c("span", re, null, 512)), [[w, (s = o(F)) == null ? void 0 : s.VL[e.value.arrangement]]])];
    }), _: 1 })]), _: 1 }, 8, ["model"])])), [[U, h.value || p.value]])]), _: 1 })) : V("", true);
  };
} }, me = $(ue, [["__scopeId", "data-v-f8b54254"]]);
export {
  me as default
};
