import { watch as C } from "vue";
import { ref as d } from "vue";
import { resolveComponent as h } from "vue";
import { openBlock as b } from "vue";
import { createBlock as g } from "vue";
import { withCtx as r } from "vue";
import { withDirectives as E } from "vue";
import { unref as i } from "vue";
import { createVNode as a } from "vue";
import { createElementVNode as y } from "vue";
import { toDisplayString as s } from "vue";
import { createTextVNode as f } from "vue";
import { isRef as U } from "vue";
import { ElTableColumn as A } from "element-plus";
import { ElTag as D } from "element-plus";
import { vLoading as H } from "element-plus";
import { s as O } from "../../../../../modules/subcontract-plan-b05fc818.js";
import { u as M, o as k, T as S, t$ as v } from "../../../../../shared/runtime.js";
const z = { style: { "margin-right": "2px" } }, F = { style: { "margin-left": "2px" } }, J = { __name: "subcontract-account", props: { modelValue: { type: Boolean, require: true }, query: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue"], setup(x, { emit: T }) {
  const V = T, c = x, { visible: p, handleClose: N } = M({ emit: V, props: c });
  C(p, (n) => {
    n && j();
  });
  const _ = d([]), w = d(), u = d(false), { maxHeight: R } = k({ mainBox: ".invoice-record", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, w);
  function L({ row: n, column: l, rowIndex: e, columnIndex: t }) {
    if (t === 1 || t === 4 || t === 5) return n.rowNumSpan ? { rowspan: n.rowNumSpan, colspan: 1 } : { rowspan: 0, colspan: 1 };
  }
  async function j() {
    if (!c.query.projectId) return false;
    const n = [];
    u.value = true;
    try {
      const { content: l = [] } = await O({ ...c.query });
      l.map((e) => {
        e.projectAreaDTOList.length && e.projectAreaDTOList.map((t, m) => {
          n.push({ ...t, supplierName: e.supplierName, username: e.username, password: e.password, areaName: t.name + "-" + t.axis, unit: t.productType === S.STRUCTURE.V ? "件" : "张", accountUnit: t.productType === S.STRUCTURE.V ? "t" : "m", rowNumSpan: m === 0 ? e.projectAreaDTOList.length : 0 });
        });
      });
    } catch (l) {
      console.log("获取分包账号失败", l);
    } finally {
      _.value = n, u.value = false;
    }
  }
  return (n, l) => {
    const e = A, t = D, m = h("common-table"), q = h("common-drawer"), B = H;
    return b(), g(q, { ref_key: "drawerRef", ref: w, title: "分包账号", "close-on-click-modal": false, modelValue: i(p), "onUpdate:modelValue": l[0] || (l[0] = (o) => U(p) ? p.value = o : null), direction: "rtl", "before-close": i(N), "custom-class": "invoice-record", size: "80%" }, { content: r(() => [E((b(), g(m, { data: _.value, "max-height": i(R), "span-method": L, stripe: false }, { default: r(() => [a(e, { label: "序号", type: "index", align: "center", width: "60" }), a(e, { prop: "supplierName", label: "分包公司", align: "center", "show-overflow-tooltip": "" }), a(e, { prop: "areaName", label: "负责区域", align: "center", "min-width": "120", "show-overflow-tooltip": "" }), a(e, { prop: "quantity", label: "分包量", align: "center", "show-overflow-tooltip": "" }, { default: r(({ row: o }) => [y("span", z, s(o.quantity) + s(o.unit), 1), l[1] || (l[1] = f("|")), y("span", F, s(o.mete) + s(o.accountUnit), 1)]), _: 1 }), a(e, { prop: "username", label: "登陆账号", align: "center", "show-overflow-tooltip": "" }), a(e, { prop: "password", label: "登陆密码", align: "center", "show-overflow-tooltip": "" }), a(e, { prop: "boolRelationStatus", label: "状态", align: "center", "show-overflow-tooltip": "", width: "80" }, { default: r(({ row: o }) => [a(t, { type: o.boolRelationStatus === i(v).FALSE.V ? "danger" : "primary" }, { default: r(() => [f(s(i(v).VL[o.boolRelationStatus]), 1)]), _: 2 }, 1032, ["type"])]), _: 1 }), a(e, { prop: "boolSettlementStatus", label: "结算状态", align: "center", "show-overflow-tooltip": "", width: "80" }, { default: r(({ row: o }) => [a(t, { type: o.boolSettlementStatus ? "success" : "primary" }, { default: r(() => [f(s(o.boolSettlementStatus ? "已结算" : "未结算"), 1)]), _: 2 }, 1032, ["type"])]), _: 1 })]), _: 1 }, 8, ["data", "max-height"])), [[B, u.value]])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  J as default
};
