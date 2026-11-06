import { computed as v } from "vue";
import { watch as L } from "vue";
import { ref as u } from "vue";
import { resolveComponent as i } from "vue";
import { resolveDirective as y } from "vue";
import { openBlock as k } from "vue";
import { createBlock as M } from "vue";
import { withCtx as s } from "vue";
import { createElementVNode as O } from "vue";
import { withDirectives as x } from "vue";
import { createVNode as e } from "vue";
import { unref as a } from "vue";
import { createElementBlock as A } from "vue";
import { createTextVNode as F } from "vue";
import { toDisplayString as J } from "vue";
import { isRef as W } from "vue";
import { ElTableColumn as G } from "element-plus";
import { ElPagination as K } from "element-plus";
import { w as Q } from "../../../../../modules/order-tracking-9be524cd.js";
import { t as X, u as Y, J as Z, o as $ } from "../../../../../shared/runtime.js";
const ee = { class: "print-wrap" }, le = { __name: "warehouse-record", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:modelValue"], setup(C, { emit: P }) {
  const z = P, { decimalPrecision: d } = X(), c = C, { visible: n, handleClose: V } = Y({ emit: z, props: c }), { handleSizeChange: B, handleCurrentChange: R, total: H, setTotalPage: j, queryPage: p } = Z({ fetchHook: _ }), h = v(() => {
    var o;
    return { projectId: (o = c.detailInfo.project) == null ? void 0 : o.id };
  });
  L(n, (o) => {
    o && _();
  });
  const w = u([]), f = u(), g = u(false), N = v(() => [["createTime", ["parse-time", "{y}-{m}-{d}"]], ["unitPrice", ["to-thousand", d.value.contract]], ["totalPrice", ["to-thousand", d.value.contract]]]), { maxHeight: S } = $({ mainBox: ".warehouse-record", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", extraHeight: "5vh", minHeight: 300, navbar: false, clientHRepMainH: true }, f);
  async function _() {
    let o = [];
    g.value = true;
    try {
      const { content: r = [], totalElements: m } = await Q({ ...h.value, ...p });
      o = r, j(m);
    } catch (r) {
      console.log("获取收款记录失败", r);
    } finally {
      w.value = o, g.value = false;
    }
  }
  return (o, r) => {
    const m = i("print-table"), T = i("table-cell-tag"), t = G, q = i("common-table"), D = K, E = i("common-drawer"), I = y("permission"), U = y("empty-text");
    return k(), M(E, { ref_key: "drawerRef", ref: f, title: "入库记录", "close-on-click-modal": false, modelValue: a(n), "onUpdate:modelValue": r[0] || (r[0] = (l) => W(n) ? n.value = l : null), direction: "rtl", "before-close": a(V), "custom-class": "warehouse-record", size: "90%" }, { titleRight: s(() => {
      var l;
      return [O("div", ee, [x(e(m, { "api-key": "projectWarehouseRecord", params: { ...h.value }, size: "default", type: "warning" }, null, 8, ["params"]), [[I, (l = c.permission) == null ? void 0 : l.print]])])];
    }), content: s(() => [e(q, { data: w.value, "data-format": N.value, "max-height": a(S) }, { default: s(() => [e(t, { align: "center", key: "monomer.name", prop: "monomer.name", label: "单体", "min-width": "140", "show-overflow-tooltip": "" }, { default: s(({ row: l }) => {
      var b;
      return [e(T, { show: l.boolAllPartSendDirectly, name: "檩条直发", color: "#f56c6c" }, null, 8, ["show"]), x((k(), A("span", null, [F(J((b = l.monomer) == null ? void 0 : b.name), 1)])), [[U]])];
    }), _: 1 }), e(t, { prop: "area.name", key: "area.name", label: "区域", align: "center", "min-width": "140", "show-overflow-tooltip": "" }), e(t, { prop: "name", key: "name", label: "名称", align: "center", "min-width": "110", "show-overflow-tooltip": "" }), e(t, { prop: "serialNumber", key: "serialNumber", label: "编号", align: "center", "min-width": "110", "show-overflow-tooltip": "" }), e(t, { prop: "specification", key: "specification", label: "规格", align: "center", "min-width": "120", "show-overflow-tooltip": "" }), e(t, { prop: "material", key: "material", label: "材质", align: "center", "min-width": "100", "show-overflow-tooltip": "" }), e(t, { prop: "measureUnit", key: "measure", label: "计量单位", align: "center", width: "70", "show-overflow-tooltip": "" }), e(t, { prop: "quantity", key: "quantity", label: "数量", align: "center", "min-width": "60", "show-overflow-tooltip": "" }), e(t, { prop: "accountingUnit", key: "nuclear", label: "核算单位", align: "center", width: "70", "show-overflow-tooltip": "" }), e(t, { prop: "mete", key: "mete", label: "总量", align: "center", "min-width": "100", "show-overflow-tooltip": "" }), e(t, { prop: "unitPrice", key: "unitPrice", label: "单价", align: "right", "min-width": "80", "show-overflow-tooltip": "" }), e(t, { prop: "totalPrice", key: "totalPrice", label: "总价", align: "right", "min-width": "100", "show-overflow-tooltip": "" }), e(t, { prop: "createTime", key: "createTime", label: "入库时间", align: "center", width: "130", "show-overflow-tooltip": "" })]), _: 1 }, 8, ["data", "data-format", "max-height"]), e(D, { total: a(H), "current-page": a(p).pageNumber, "page-size": a(p).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: a(B), onCurrentChange: a(R) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} };
export {
  le as default
};
