import { ref as m } from "vue";
import { resolveComponent as i } from "vue";
import { openBlock as H } from "vue";
import { createBlock as R } from "vue";
import { withCtx as n } from "vue";
import { createVNode as e } from "vue";
import { createTextVNode as V } from "vue";
import { toDisplayString as p } from "vue";
import { createElementVNode as d } from "vue";
import { unref as s } from "vue";
import { ElTag as k } from "element-plus";
import { ElTableColumn as N } from "element-plus";
import { _ as S, u as C, kc as j, D as A, o as E, uV as P } from "../../../../shared/runtime.js";
import { u as U } from "../../../../modules/useTableTotal-3d22365a.js";
const z = { class: "head-container" }, I = { class: "table-container" }, L = { __name: "pre-settlement-detail", props: { modelValue: { type: Boolean, required: true }, currentRow: { type: Object, default: () => {
} } }, emits: ["update:modelValue"], setup(u, { emit: _ }) {
  const t = u, b = _, l = m([]), f = async () => {
    try {
      const { content: r } = await P({ id: t.currentRow.id });
      l.value = r;
    } catch (r) {
      console.log(r);
    }
  }, { visible: h, handleClose: g } = C({ emit: b, props: t, showHook: f });
  j();
  const w = m([["amount", ["to-thousand", A.YUAN]], ["createTime", ["parse-time", "{y}-{m}-{d}"]]]), { getSummaries: x } = U(false, { defineData: ["amount"] }), { maxHeight: v } = E({ mainBox: ".storage-detail", extraBox: [".el-drawer__header", ".head-container"], wrapperBox: [".table-container"], paginate: false, navbar: false, minHeight: 300, extraHeight: 40, clientHRepMainH: true }, l.value);
  return (r, M) => {
    const y = k, B = i("print-table"), a = N, D = i("common-table"), T = i("common-drawer");
    return H(), R(T, { appendToBody: true, "before-close": s(g), visible: s(h), "custom-class": "storage-detail", size: "90%", title: "预结办理记录" }, { titleAfter: n(() => [e(y, null, { default: n(() => {
      var o, c;
      return [V(p("供应商：" + ((o = t.currentRow.supplier) == null ? void 0 : o.name)) + "   |   " + p("项目：" + ((c = t.currentRow) == null ? void 0 : c.projects)), 1)];
    }), _: 1 })]), content: n(() => {
      var o;
      return [d("div", z, [e(B, { params: { orderId: (o = t.currentRow) == null ? void 0 : o.id }, "api-key": "preSettlementDetail", size: "default", type: "warning" }, null, 8, ["params"])]), d("div", I, [e(D, { ref: "tableRef", data: l.value, "data-format": w.value, "max-height": s(v), "summary-method": s(x), "show-summary": "", stripe: "" }, { default: n(() => [e(a, { align: "center", label: "序号", type: "index", width: "60" }), e(a, { align: "center", label: "日期", prop: "createTime", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "预结金额", prop: "amount", "show-overflow-tooltip": "" }), e(a, { align: "center", label: "办理人", prop: "applyUserName" }), e(a, { align: "center", label: "审核人", prop: "auditUserName" })]), _: 1 }, 8, ["data", "data-format", "max-height", "summary-method"])])];
    }), _: 1 }, 8, ["before-close", "visible"]);
  };
} }, Y = S(L, [["__scopeId", "data-v-9a79c889"]]);
export {
  Y as default
};
