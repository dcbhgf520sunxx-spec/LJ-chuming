import { ref as f } from "vue";
import { watch as S } from "vue";
import { resolveComponent as b } from "vue";
import { openBlock as q } from "vue";
import { createBlock as M } from "vue";
import { withCtx as o } from "vue";
import { createVNode as t } from "vue";
import { unref as a } from "vue";
import { createElementVNode as r } from "vue";
import { toDisplayString as n } from "vue";
import { isRef as R } from "vue";
import { ElTableColumn as j } from "element-plus";
import { ElPagination as D } from "element-plus";
import { o as E } from "../../../../modules/contract-ledger-2ee7c4ce.js";
import { _ as T, t as A, u as L, J, o as O, bV as g } from "../../../../shared/runtime.js";
const U = { style: { cursor: "pointer" } }, F = { __name: "occur-amount", props: { modelValue: { type: Boolean, require: true }, projectId: { type: [String, Number], default: void 0 } }, emits: ["success", "update:modelValue"], setup(y, { emit: v }) {
  const u = y, { decimalPrecision: w } = A(), c = f([]), _ = f(), p = f(false), x = v, { visible: d, handleClose: k } = L({ emit: x, props: u }), { handleSizeChange: C, handleCurrentChange: P, total: V, setTotalPage: z, queryPage: m } = J({ fetchHook: h });
  S(() => u.projectId, (s) => {
    s ? h() : c.value = [];
  }, { deep: true, immediate: true });
  const { maxHeight: B } = O({ mainBox: ".occur-detail", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, _);
  async function h() {
    p.value = true;
    try {
      const { content: s, totalElements: i } = await E({ projectId: u.projectId, ...m });
      c.value = s || [], z(i);
    } catch (s) {
      console.log("获取变更金额记录", s);
    } finally {
      p.value = false;
    }
  }
  return (s, i) => {
    const l = j, N = b("common-table"), H = D, I = b("common-drawer");
    return q(), M(I, { ref_key: "drawerRef", ref: _, "append-to-body": "", modelValue: a(d), "onUpdate:modelValue": i[0] || (i[0] = (e) => R(d) ? d.value = e : null), top: "10vh", width: "600px", "before-close": a(k), title: "发生记录", "custom-class": "occur-detail", "wrapper-closable": false, size: "80%" }, { content: o(() => [t(N, { ref: "tableRef", data: c.value, "max-height": a(B) - 60, loading: p.value, style: { width: "100%" }, "return-source-data": "" }, { default: o(() => [t(l, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(l, { key: "name", prop: "name", "show-overflow-tooltip": true, label: "名称" }, { default: o((e) => [r("span", U, n(e.row.name), 1)]), _: 1 }), t(l, { key: "serialNumber", prop: "serialNumber", "show-overflow-tooltip": true, label: "编号", "min-width": "120" }, { default: o((e) => [r("span", null, n(e.row.serialNumber), 1)]), _: 1 }), t(l, { key: "specification", prop: "specification", "show-overflow-tooltip": true, label: "规格", "min-width": "120" }, { default: o((e) => [r("span", null, n(e.row.specification), 1)]), _: 1 }), t(l, { key: "material", prop: "material", "show-overflow-tooltip": true, label: "材质" }, { default: o((e) => [r("span", null, n(e.row.material), 1)]), _: 1 }), t(l, { key: "measure", prop: "measure", "show-overflow-tooltip": true, label: "计量单位", width: "70" }, { default: o((e) => [r("span", null, n(e.row.measure), 1)]), _: 1 }), t(l, { key: "quantity", prop: "quantity", "show-overflow-tooltip": true, label: "数量" }, { default: o((e) => [r("span", null, n(e.row.quantity), 1)]), _: 1 }), t(l, { key: "nuclear", prop: "nuclear", "show-overflow-tooltip": true, label: "核算单位", width: "70" }, { default: o((e) => [r("span", null, n(e.row.nuclear), 1)]), _: 1 }), t(l, { key: "totalMete", prop: "totalMete", "show-overflow-tooltip": true, label: "总量" }, { default: o((e) => [r("span", null, n(e.row.totalMete), 1)]), _: 1 }), t(l, { key: "unitPrice", prop: "unitPrice", "show-overflow-tooltip": true, label: "单价" }, { default: o((e) => [r("span", null, n(e.row.unitPrice ? a(g)(e.row.unitPrice, a(w).contract) : 0), 1)]), _: 1 }), t(l, { key: "totalPrice", prop: "totalPrice", "show-overflow-tooltip": true, label: "总价" }, { default: o((e) => [r("span", null, n(e.row.totalPrice ? a(g)(e.row.totalPrice, a(w).contract) : 0), 1)]), _: 1 })]), _: 1 }, 8, ["data", "max-height", "loading"]), t(H, { total: a(V), "current-page": a(m).pageNumber, "page-size": a(m).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: a(C), onCurrentChange: a(P) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, W = T(F, [["__scopeId", "data-v-bb7747b2"]]);
export {
  W as default
};
