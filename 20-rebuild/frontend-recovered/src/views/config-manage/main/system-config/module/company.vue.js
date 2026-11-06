import { useStore as L } from "vuex";
import { ref as p } from "vue";
import { computed as T } from "vue";
import { resolveComponent as j } from "vue";
import { resolveDirective as M } from "vue";
import { unref as t } from "vue";
import { openBlock as o } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as l } from "vue";
import { createElementVNode as v } from "vue";
import { createElementBlock as d } from "vue";
import { createVNode as i } from "vue";
import { createTextVNode as V } from "vue";
import { createCommentVNode as w } from "vue";
import { withDirectives as y } from "vue";
import { ElMessage as O } from "element-plus";
import { nextTick as P } from "vue";
import { ElInput as A } from "element-plus";
import { ElFormItem as G } from "element-plus";
import { ElForm as Q } from "element-plus";
import { ElCard as H } from "element-plus";
import { vLoading as J } from "element-plus";
import { _ as K, d as W, G as m, eQ as X, eL as Y, eR as C, eS as E, eT as Z } from "../../../../../shared/runtime.js";
const $ = { key: 0, style: { float: "right" } }, ee = { class: "input-underline" }, ae = { key: 1 }, te = { class: "input-underline" }, oe = { key: 1 }, le = { class: "input-underline" }, ne = { key: 1 }, se = { class: "input-underline" }, ue = { key: 1 }, re = { __name: "company", setup(ie) {
  const n = Y.company, k = { companyNo: void 0, companyName: void 0, website: void 0, telephone: void 0 }, F = L(), x = p(), N = p(false), f = p(false), a = p({ ...k }), g = p({ ...k }), B = { companyNo: [{ required: true, message: "请填写公司编号", trigger: "blur" }, { min: 2, max: 10, message: "编号长度为2-10个字符", trigger: "blur" }, { pattern: C.pattern, message: C.message, trigger: "blur" }], companyName: [{ required: true, message: "请填写公司名称", trigger: "blur" }, { min: 2, max: 60, message: "名称长度不少于2个字，不多于60个字", trigger: "blur" }, { pattern: E.pattern, message: E.message, trigger: "blur" }] }, D = T(() => !W(a.value, g.value));
  q();
  async function q() {
    if (m(n.get)) {
      N.value = true;
      try {
        const { companyNo: s, companyName: e, website: c, telephone: u } = await X() || {};
        g.value = { companyNo: s, companyName: e, website: c, telephone: u }, a.value = { companyNo: s, companyName: e, website: c, telephone: u };
      } catch (s) {
        console.log("error", s);
      } finally {
        N.value = false;
      }
    }
  }
  function R() {
    x.value.validate(async (s) => {
      if (s) {
        f.value = true;
        try {
          await Z(a.value), g.value = { ...a.value }, O.success("修改成功"), F.dispatch("config/fetchCompany");
        } catch (e) {
          console.log("设置基础信息：项目信息", e);
        } finally {
          f.value = false;
        }
      } else return false;
    });
  }
  function S() {
    a.value = { ...g.value }, P(() => {
      x.value.clearValidate();
    });
  }
  return (s, e) => {
    const c = j("common-button"), u = A, b = G, U = Q, z = H, h = M("empty-text"), I = J;
    return t(m)(t(n).get) ? (o(), _(z, { key: 0, class: "box-card", shadow: "hover" }, { header: l(() => [e[6] || (e[6] = v("span", { class: "title" }, "公司信息配置", -1)), t(m)(t(n).edit) && D.value ? (o(), d("div", $, [i(c, { size: "default", type: "warning", onClick: S }, { default: l(() => e[4] || (e[4] = [V("取消修改")])), _: 1, __: [4] }), i(c, { loading: f.value, size: "default", type: "success", onClick: R }, { default: l(() => e[5] || (e[5] = [V("保存")])), _: 1, __: [5] }, 8, ["loading"])])) : w("", true)]), default: l(() => [y((o(), d("div", null, [i(U, { ref_key: "companyFormRef", ref: x, model: a.value, rules: B, class: "demo-ruleForm", "label-width": "80px" }, { default: l(() => [i(b, { label: "公司编号", prop: "companyNo" }, { default: l(() => [v("div", ee, [t(m)(t(n).edit) ? (o(), _(u, { key: 0, modelValue: a.value.companyNo, "onUpdate:modelValue": e[0] || (e[0] = (r) => a.value.companyNo = r), type: "text", placeholder: "请填写公司编号", style: { width: "500px" }, autocomplete: "off" }, null, 8, ["modelValue"])) : y((o(), d("span", ae, null, 512)), [[h, a.value.companyNo]])])]), _: 1 }), i(b, { label: "公司名称", prop: "companyName" }, { default: l(() => [v("div", te, [t(m)(t(n).edit) ? (o(), _(u, { key: 0, modelValue: a.value.companyName, "onUpdate:modelValue": e[1] || (e[1] = (r) => a.value.companyName = r), type: "text", placeholder: "请填写公司名称", autocomplete: "off", style: { width: "500px" } }, null, 8, ["modelValue"])) : y((o(), d("span", oe, null, 512)), [[h, a.value.companyName]])])]), _: 1 }), i(b, { label: "公司网址", prop: "website" }, { default: l(() => [v("div", le, [t(m)(t(n).edit) ? (o(), _(u, { key: 0, modelValue: a.value.website, "onUpdate:modelValue": e[2] || (e[2] = (r) => a.value.website = r), type: "text", placeholder: "请填写公司网址", maxlength: "32", autocomplete: "off", style: { width: "500px" } }, null, 8, ["modelValue"])) : y((o(), d("span", ne, null, 512)), [[h, a.value.website]])])]), _: 1 }), i(b, { label: "公司电话", prop: "telephone" }, { default: l(() => [v("div", se, [t(m)(t(n).edit) ? (o(), _(u, { key: 0, modelValue: a.value.telephone, "onUpdate:modelValue": e[3] || (e[3] = (r) => a.value.telephone = r), type: "text", placeholder: "请填写公司电话", maxlength: "32", autocomplete: "off", style: { width: "500px" } }, null, 8, ["modelValue"])) : y((o(), d("span", ue, null, 512)), [[h, a.value.telephone]])])]), _: 1 })]), _: 1 }, 8, ["model"])])), [[I, N.value || f.value]])]), _: 1 })) : w("", true);
  };
} }, ce = K(re, [["__scopeId", "data-v-f867a0ba"]]);
export {
  ce as default
};
