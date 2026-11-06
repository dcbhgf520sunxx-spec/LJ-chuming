import { inject as L } from "vue";
import { computed as w } from "vue";
import { ref as S } from "vue";
import { nextTick as x } from "vue";
import { watch as M } from "vue";
import { resolveDirective as P } from "vue";
import { openBlock as d } from "vue";
import { createElementBlock as v } from "vue";
import { createVNode as n } from "vue";
import { withCtx as o } from "vue";
import { createElementVNode as p } from "vue";
import { toDisplayString as h } from "vue";
import { unref as r } from "vue";
import { Fragment as R } from "vue";
import { renderList as q } from "vue";
import { createBlock as E } from "vue";
import { withDirectives as K } from "vue";
import { createTextVNode as U } from "vue";
import { InfoFilled as O } from "@element-plus/icons-vue";
import { ElIcon as Q } from "element-plus";
import { ElPopover as G } from "element-plus";
import { ElInput as H } from "element-plus";
import { ElOption as J } from "element-plus";
import { ElSelect as W } from "element-plus";
import { ElButton as X } from "element-plus";
import { ElUpload as Y } from "element-plus";
import { p as Z, b as $ } from "../../../../../../../modules/data-499610b6.js";
import { i as ee } from "../../../../../../../modules/grant-managment-2c540b60.js";
import { _ as te, e3 as ae, e7 as b, ia as le, e2 as V, i as oe, iv as ne, e5 as se } from "../../../../../../../shared/runtime.js";
import { u as ce } from "../../../../../../../modules/upload-file-download-812f558c.js";
const re = { class: "second-table-container" }, ue = { class: "label-container" }, ie = { style: { "font-size": "14px" } }, me = { class: "label-container" }, de = { style: { "font-size": "14px" } }, pe = { key: 0, class: "notSlotValue" }, _e = `
内包制： 项目经理下所有项目的收入金额 + 当前项目的注资金额；

合营： 项目经理下的所有项目的 项目经理注资 + 签订主体注资 + 收入的钱
`, fe = `
内包制：当前项目下的 项目经理注资 + 收入的钱；

合营 ：当前项目下的 项目经理注资 + 签订主体注资 + 收入的钱
`, ye = { __name: "second-table", setup(ve, { expose: I }) {
  const C = L("payment_data"), { formData: t, projectInfo: i } = C, m = w(() => ae($, i)), _ = S(false), g = w(() => {
    if (!t.purchaseContractNumber) return;
    let a = m.value.find((e) => e.key === "personalCredit").value;
    if (a = a ? b(a) : 0, !(typeof a > "u")) if (i.projectAttribute === 2) {
      let e = m.value.find((s) => s.key === "contractCollectionSummary").value;
      return e = e ? b(e) : 0, B(e, a);
    } else {
      let e = m.value.find((s) => s.key === "collectionSummary").value;
      return e = e ? b(e) : 0, B(e, a);
    }
  });
  function B(a, e) {
    if (e || a) {
      const s = e + a;
      if (t.paymentAmount && t.paymentAmount <= s) return le(t.paymentAmount);
      if (t.paymentAmount && t.paymentAmount > s) return t.paymentAmount = null, setTimeout(() => {
        x(() => {
          i.projectAttribute === 2 ? V("warning", "本次付款额不能大于本项目结余加授信额度") : V("warning", "本次付款额不能大于总结余加授信额度");
        });
      }, 100), null;
    } else if (!e && oe(i.personalCredit)) return t.paymentAmount = null, _.value = true, setTimeout(() => {
      _.value && x(() => {
        V("error", "余额不足");
      }), _.value = false;
    }, 100), null;
  }
  M(() => g.value, (a) => {
    console.log(a), i.capital = a ? g.value : null;
  });
  const f = S(""), D = async (a) => {
    const { id: e, data: s } = await ce(a, ee);
    t.attachmentId = e, f.value = s[0].name;
  };
  return I({ secondData: m }), (a, e) => {
    const s = O, A = Q, k = G, y = H, j = J, N = W, T = X, z = Y, F = P("ellipsis");
    return d(), v("div", re, [n(se, { column: 3, "form-data": r(t), "form-rules": r(Z), "table-list": m.value, "item-width": "8vw" }, { collectionSummary_label: o(({ label: l }) => [p("div", ue, [p("span", ie, h(l), 1), n(k, { content: _e, width: 300, placement: "left", title: "总结余", trigger: "hover" }, { reference: o(() => [n(A, { class: "icon" }, { default: o(() => [n(s)]), _: 1 })]), _: 1 })])]), contractCollectionSummary_label: o(({ label: l }) => [p("div", me, [p("span", de, h(l), 1), n(k, { content: fe, width: 300, placement: "left", title: "本项目结余", trigger: "hover" }, { reference: o(() => [n(A, { class: "icon" }, { default: o(() => [n(s)]), _: 1 })]), _: 1 })])]), paymentAmount: o(({ item: l, blur: u }) => [n(y, { modelValue: r(t)[l], "onUpdate:modelValue": (c) => r(t)[l] = c, modelModifiers: { number: true }, clearable: "", placeholder: "请输入申请金额", type: "number", onBlur: u }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"])]), paymentBank: o(({ item: l, blur: u }) => [n(y, { modelValue: r(t)[l], "onUpdate:modelValue": (c) => r(t)[l] = c, clearable: "", placeholder: "请输入付款银行", onBlur: u }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"])]), paymentReasonId: o(({ item: l, blur: u }) => [n(N, { modelValue: r(t)[l], "onUpdate:modelValue": (c) => r(t)[l] = c, clearable: "", placeholder: "请选择付款事由", onBlur: () => u() }, { default: o(() => [(d(true), v(R, null, q(r(ne).V, (c) => (d(), E(j, { key: c.K, label: c.L, value: c.V }, null, 8, ["label", "value"]))), 128))]), _: 2 }, 1032, ["modelValue", "onUpdate:modelValue", "onBlur"])]), paymentBankAccount: o(({ item: l, blur: u }) => [n(y, { modelValue: r(t)[l], "onUpdate:modelValue": (c) => r(t)[l] = c, clearable: "", placeholder: "请输入账户", onBlur: () => u() }, null, 8, ["modelValue", "onUpdate:modelValue", "onBlur"])]), attachment: o(() => [f.value ? K((d(), v("span", pe, [U(h(f.value), 1)])), [[F]]) : (d(), E(z, { key: 1, "auto-upload": false, "on-change": D, "show-file-list": false, action: "#", multiple: "" }, { default: o(() => [n(T, { icon: "el-icon-upload", plain: "", size: "default", type: "primary" }, { default: o(() => e[0] || (e[0] = [U("导入")])), _: 1, __: [0] })]), _: 1 }))]), _: 1 }, 8, ["form-data", "form-rules", "table-list"])]);
  };
} }, we = te(ye, [["__scopeId", "data-v-996de66f"]]);
export {
  we as default
};
