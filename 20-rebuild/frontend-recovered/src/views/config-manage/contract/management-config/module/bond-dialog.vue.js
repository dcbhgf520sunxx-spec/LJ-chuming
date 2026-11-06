import { ref as d } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as g } from "vue";
import { createVNode as e } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as w } from "vue";
import { createBlock as x } from "vue";
import { createTextVNode as b } from "vue";
import { createCommentVNode as C } from "vue";
import { Fragment as R } from "vue";
import { renderList as $ } from "vue";
import { ElMessage as k } from "element-plus";
import { ElButton as I } from "element-plus";
import { ElOption as L } from "element-plus";
import { ElSelect as O } from "element-plus";
import { ElTableColumn as S } from "element-plus";
import { ElInput as H } from "element-plus";
import { ElCol as Q } from "element-plus";
import { ElRow as q } from "element-plus";
import { ElTable as G } from "element-plus";
import { ElDialog as J } from "element-plus";
import { f as K, h as P } from "../../../../../modules/management-config-46730d2f.js";
import { _ as W, dp as X } from "../../../../../shared/runtime.js";
const Y = { class: "custom-dialog" }, Z = { __name: "bond-dialog", emits: ["close"], setup(ee, { expose: D, emit: E }) {
  const i = d(false), r = d(""), v = d(""), u = d(false), y = [{ label: "合营", value: 2 }, { label: "内包制", value: 3 }], V = { projectAttribute: "", amountMin: "", amountMax: "", cashDeposit: "" }, s = d([{ projectAttribute: "", amountMin: "", amountMax: "", cashDeposit: "" }]), j = () => {
    s.value.push({ ...V });
  }, M = (t) => {
    s.value.splice(t, 1);
  }, A = E, _ = () => {
    s.value = [{ ...V }], A("close");
  }, B = async () => {
    if (u.value = true, s.value.forEach((t) => {
      t.cashDeposit && (t.cashDeposit = parseFloat(t.cashDeposit));
    }), typeof s.value[0].projectAttribute != "number" && y.forEach((t, o) => {
      t.label === s.value[0].projectAttribute && (s.value[0].projectAttribute = t.value);
    }), r.value === "edit") try {
      await K(s.value[0]), k({ showClose: true, message: "修改成功", type: "success" }), _(), u.value = false;
    } catch (t) {
      console.error("修改失败", t);
    } finally {
      u.value = false;
    }
    else if (r.value === "add") try {
      await P(s.value), k({ showClose: true, message: "新增成功", type: "success" }), _(), u.value = false;
    } catch (t) {
      console.error("新增失败", t);
    } finally {
      u.value = false;
    }
  };
  return D({ dialogVisible: i, Title: v, openType: r, tableList: s }), (t, o) => {
    const c = I, T = L, U = O, p = S, f = H, h = Q, z = q, N = G, F = J;
    return m(), g("div", Y, [e(F, { modelValue: i.value, "onUpdate:modelValue": o[1] || (o[1] = (l) => i.value = l), "show-close": false, width: "50%", onClose: _ }, { header: a(() => [e(X, { headerTitle: v.value, "type-one": false }, { headerRight: a(() => [w("div", null, [r.value !== "edit" ? (m(), x(c, { key: 0, icon: "el-icon-plus", type: "success", onClick: j }, { default: a(() => o[2] || (o[2] = [b("添加 ")])), _: 1, __: [2] })) : C("", true), e(c, { loading: u.value, type: "primary", onClick: B }, { default: a(() => o[3] || (o[3] = [b(" 确定")])), _: 1, __: [3] }, 8, ["loading"]), e(c, { onClick: o[0] || (o[0] = (l) => i.value = false) }, { default: a(() => o[4] || (o[4] = [b("取消")])), _: 1, __: [4] })])]), _: 1 }, 8, ["headerTitle"])]), default: a(() => [e(N, { data: s.value, border: "" }, { default: a(() => [e(p, { align: "center", label: "项目类型", "min-width": "180", prop: "projectAttribute" }, { default: a((l) => [e(U, { modelValue: l.row.projectAttribute, "onUpdate:modelValue": (n) => l.row.projectAttribute = n, modelModifiers: { number: true }, placeholder: "请选择项目类型" }, { default: a(() => [(m(), g(R, null, $(y, (n) => e(T, { key: n.value, label: n.label, value: n.value }, null, 8, ["label", "value"])), 64))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), e(p, { align: "center", label: "合同额（元）", "min-width": "300", prop: "contractAmount" }, { default: a((l) => [e(z, { justify: "space-between", type: "flex" }, { default: a(() => [e(h, { span: 11 }, { default: a(() => [e(f, { modelValue: l.row.amountMin, "onUpdate:modelValue": (n) => l.row.amountMin = n, modelModifiers: { number: true }, clearable: "", placeholder: "最小金额", size: "default", style: { "font-size": "14px" }, type: "number" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1024), o[5] || (o[5] = w("span", null, "-", -1)), e(h, { span: 11 }, { default: a(() => [e(f, { modelValue: l.row.amountMax, "onUpdate:modelValue": (n) => l.row.amountMax = n, modelModifiers: { number: true }, clearable: "", placeholder: "最大金额", size: "default", style: { "font-size": "14px" }, type: "number" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1024)]), _: 2, __: [5] }, 1024)]), _: 1 }), e(p, { align: "center", label: "保证金（元）", "min-width": "180", prop: "cashDeposit" }, { default: a((l) => [e(f, { modelValue: l.row.cashDeposit, "onUpdate:modelValue": (n) => l.row.cashDeposit = n, clearable: "", placeholder: "请输入保证金" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), r.value !== "edit" ? (m(), x(p, { key: 0, align: "center", label: "操作", width: "80" }, { default: a((l) => [e(c, { icon: "el-icon-delete", type: "danger", onClick: (n) => M(l.$index) }, null, 8, ["onClick"])]), _: 1 })) : C("", true)]), _: 1 }, 8, ["data"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, oe = W(Z, [["__scopeId", "data-v-6e6dc8bf"]]);
export {
  oe as default
};
