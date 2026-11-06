import { ref as C } from "vue";
import { resolveComponent as d } from "vue";
import { openBlock as V } from "vue";
import { createBlock as k } from "vue";
import { withCtx as n } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as t } from "vue";
import { toDisplayString as l } from "vue";
import { unref as p } from "vue";
import { isRef as I } from "vue";
import { ElDescriptionsItem as x } from "element-plus";
import { ElDescriptions as E } from "element-plus";
import { u as h } from "../../../../shared/runtime.js";
const j = { __name: "firm-information-dialog", props: { modelValue: { type: Boolean, default: false }, information: { type: [String, Number, Object], default: void 0 } }, emits: ["update:modelValue", "success"], setup(_, { emit: b }) {
  const o = _, u = b, { visible: r, handleClose: f } = h({ emit: u, props: o }), s = C({});
  function v() {
    s.value.creditCode = o.information.creditCode, s.value.businessName = o.information.companyName, s.value.liaisons = o.information.keyPersonName, s.value.businessPhone = o.information.phoneNumber, s.value.businessEmail = o.information.email, s.value.address = o.information.regLocation, u("success", s.value), f();
  }
  return (B, m) => {
    const y = d("common-button"), i = x, N = E, g = d("common-dialog");
    return V(), k(g, { modelValue: p(r), "onUpdate:modelValue": m[0] || (m[0] = (e) => I(r) ? r.value = e : null), "before-close": p(f), "close-on-click-modal": false, title: "企业信息" }, { titleRight: n(() => [a(y, { size: "default", type: "primary", onClick: v }, { default: n(() => m[1] || (m[1] = [t("确认")])), _: 1, __: [1] })]), default: n(() => [a(N, { border: "", column: 2 }, { default: n(() => [a(i, { label: "企业名称" }, { default: n(() => {
      var e;
      return [t(l(((e = o.information) == null ? void 0 : e.companyName) || "-"), 1)];
    }), _: 1 }), a(i, { label: "社会统一信用代码" }, { default: n(() => {
      var e;
      return [t(l(((e = o.information) == null ? void 0 : e.creditCode) || "-"), 1)];
    }), _: 1 }), a(i, { label: "联系人" }, { default: n(() => {
      var e;
      return [t(l(((e = o.information) == null ? void 0 : e.keyPersonName) || "-"), 1)];
    }), _: 1 }), a(i, { label: "详细地址" }, { default: n(() => {
      var e;
      return [t(l(((e = o.information) == null ? void 0 : e.regLocation) || "-"), 1)];
    }), _: 1 }), a(i, { label: "所在省市区" }, { default: n(() => {
      var e, c;
      return [t(l(((e = o.information) == null ? void 0 : e.province) + ((c = o.information) == null ? void 0 : c.city) + o.information.district || "-"), 1)];
    }), _: 1 }), a(i, { label: "所属行业" }, { default: n(() => {
      var e;
      return [t(l(((e = o.information) == null ? void 0 : e.subIndustry) || "-"), 1)];
    }), _: 1 }), a(i, { label: "企业邮箱" }, { default: n(() => {
      var e;
      return [t(l(((e = o.information) == null ? void 0 : e.email) || "-"), 1)];
    }), _: 1 }), a(i, { label: "联系电话" }, { default: n(() => {
      var e;
      return [t(l(((e = o.information) == null ? void 0 : e.phoneNumber) || "-"), 1)];
    }), _: 1 })]), _: 1 })]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  j as default
};
