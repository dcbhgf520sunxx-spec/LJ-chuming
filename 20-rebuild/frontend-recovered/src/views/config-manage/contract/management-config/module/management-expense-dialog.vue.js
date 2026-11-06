import { ref as i } from "vue";
import { openBlock as m } from "vue";
import { createElementBlock as w } from "vue";
import { createVNode as e } from "vue";
import { withCtx as a } from "vue";
import { createElementVNode as x } from "vue";
import { createBlock as h } from "vue";
import { createTextVNode as b } from "vue";
import { createCommentVNode as M } from "vue";
import { Fragment as R } from "vue";
import { renderList as $ } from "vue";
import { ElMessage as C } from "element-plus";
import { ElButton as I } from "element-plus";
import { ElOption as L } from "element-plus";
import { ElSelect as O } from "element-plus";
import { ElTableColumn as S } from "element-plus";
import { ElInput as H } from "element-plus";
import { ElCol as Q } from "element-plus";
import { ElRow as q } from "element-plus";
import { ElTable as G } from "element-plus";
import { ElDialog as J } from "element-plus";
import { p as K, i as P } from "../../../../../modules/management-config-46730d2f.js";
import { _ as W, dp as X } from "../../../../../shared/runtime.js";
const Y = { class: "custom-dialog" }, Z = { __name: "management-expense-dialog", emits: ["close"], setup(ee, { expose: k, emit: E }) {
  const d = i(false), r = i(""), v = i(""), u = i(false), g = [{ label: "合营", value: 2 }, { label: "内包制", value: 3 }], y = { projectAttribute: "", amountMin: "", amountMax: "", cashDeposit: "" }, n = i([{ projectAttribute: "", amountMin: "", amountMax: "", cashDeposit: "" }]), j = () => {
    n.value.push({ ...y });
  }, A = (s) => {
    n.value.splice(s, 1);
  }, D = E, _ = () => {
    n.value = [{ ...y }], D("close");
  }, T = async () => {
    if (u.value = true, typeof n.value[0].projectAttribute != "number" && g.forEach((s, t) => {
      s.label === n.value[0].projectAttribute && (n.value[0].projectAttribute = s.value);
    }), r.value === "edit") try {
      await K(n.value[0]), C({ showClose: true, message: "修改成功", type: "success" }), _(), u.value = false;
    } catch (s) {
      console.error("修改管理费失败:", s);
    } finally {
      u.value = false;
    }
    else if (r.value === "add") try {
      await P(n.value), C({ showClose: true, message: "新增成功", type: "success" }), _(), u.value = false;
    } catch (s) {
      console.error("新增管理费失败:" + s);
    } finally {
      u.value = false;
    }
  };
  return k({ dialogVisible: d, Title: v, openType: r, tableList: n }), (s, t) => {
    const c = I, U = L, B = O, p = S, f = H, V = Q, z = q, F = G, N = J;
    return m(), w("div", Y, [e(N, { modelValue: d.value, "onUpdate:modelValue": t[1] || (t[1] = (l) => d.value = l), "show-close": false, width: "50%", onClose: _ }, { header: a(() => [e(X, { headerTitle: v.value, "type-one": false }, { headerRight: a(() => [x("div", null, [r.value !== "edit" ? (m(), h(c, { key: 0, icon: "el-icon-plus", type: "success", onClick: j }, { default: a(() => t[2] || (t[2] = [b("添加 ")])), _: 1, __: [2] })) : M("", true), e(c, { loading: u.value, type: "primary", onClick: T }, { default: a(() => t[3] || (t[3] = [b(" 确定")])), _: 1, __: [3] }, 8, ["loading"]), e(c, { onClick: t[0] || (t[0] = (l) => d.value = false) }, { default: a(() => t[4] || (t[4] = [b("取消")])), _: 1, __: [4] })])]), _: 1 }, 8, ["headerTitle"])]), default: a(() => [e(F, { data: n.value, border: "" }, { default: a(() => [e(p, { align: "center", label: "项目类型", "min-width": "180", prop: "projectAttribute" }, { default: a((l) => [e(B, { modelValue: l.row.projectAttribute, "onUpdate:modelValue": (o) => l.row.projectAttribute = o, modelModifiers: { number: true }, placeholder: "请选择项目类型" }, { default: a(() => [(m(), w(R, null, $(g, (o) => e(U, { key: o.value, label: o.label, value: o.value }, null, 8, ["label", "value"])), 64))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), e(p, { align: "center", label: "合同额（元）", "min-width": "300", prop: "contractAmount" }, { default: a((l) => [e(z, { justify: "space-between", type: "flex" }, { default: a(() => [e(V, { span: 11 }, { default: a(() => [e(f, { modelValue: l.row.amountMin, "onUpdate:modelValue": (o) => l.row.amountMin = o, modelModifiers: { number: true }, clearable: "", placeholder: "请输入最小金额", size: "default", style: { "font-size": "14px" }, type: "number" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1024), t[5] || (t[5] = x("span", null, "-", -1)), e(V, { span: 11 }, { default: a(() => [e(f, { modelValue: l.row.amountMax, "onUpdate:modelValue": (o) => l.row.amountMax = o, modelModifiers: { number: true }, clearable: "", placeholder: "请输入最大金额", size: "default", style: { "font-size": "14px" }, type: "number" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 2 }, 1024)]), _: 2, __: [5] }, 1024)]), _: 1 }), e(p, { align: "center", label: "管理费（%）", "min-width": "180", prop: "cashDeposit" }, { default: a((l) => [e(f, { modelValue: l.row.cashDeposit, "onUpdate:modelValue": (o) => l.row.cashDeposit = o, modelModifiers: { number: true }, clearable: "", placeholder: "请输入管理费率", type: "number" }, null, 8, ["modelValue", "onUpdate:modelValue"])]), _: 1 }), r.value !== "edit" ? (m(), h(p, { key: 0, align: "center", label: "操作", width: "80" }, { default: a((l) => [e(c, { icon: "el-icon-delete", type: "danger", onClick: (o) => A(l.$index) }, null, 8, ["onClick"])]), _: 1 })) : M("", true)]), _: 1 }, 8, ["data"])]), _: 1 }, 8, ["modelValue"])]);
  };
} }, oe = W(Z, [["__scopeId", "data-v-c1591070"]]);
export {
  oe as default
};
