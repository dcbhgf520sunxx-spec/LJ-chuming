import { ref as p } from "vue";
import { watch as A } from "vue";
import { resolveComponent as y } from "vue";
import { openBlock as m } from "vue";
import { createBlock as u } from "vue";
import { withCtx as s } from "vue";
import { createVNode as t } from "vue";
import { createTextVNode as M } from "vue";
import { toDisplayString as C } from "vue";
import { unref as n } from "vue";
import { createElementVNode as O } from "vue";
import { normalizeStyle as H } from "vue";
import { withDirectives as L } from "vue";
import { createCommentVNode as R } from "vue";
import { isRef as F } from "vue";
import { ElTag as Q } from "element-plus";
import { ElTableColumn as J } from "element-plus";
import { ElPagination as $ } from "element-plus";
import { vLoading as X } from "element-plus";
import { a as Y } from "../../../../../../modules/product-receive-send-storage-7de51d86.js";
import { u as Z, J as ee, o as te, D as h, bM as x, z as ae, ba as oe } from "../../../../../../shared/runtime.js";
const ie = { __name: "type-detail", props: { modelValue: { type: Boolean, require: true }, detailInfo: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} }, showType: { type: String, default: void 0 }, detailQuery: { type: Object, default: () => {
} }, workshopId: { type: Number }, productType: { type: Number } }, emits: ["update:modelValue", "success"], setup(e, { emit: D }) {
  const _ = D, g = p({}), l = e, { visible: d, handleClose: B } = Z({ emit: _, props: l }), { handleSizeChange: W, handleCurrentChange: U, total: S, setTotalPage: z, queryPage: w } = ee({ fetchHook: N });
  A(d, (i) => {
    var r;
    i && (g.value.dateTimeList = (r = l.detailQuery) == null ? void 0 : r.dateTimeList, N());
  });
  const T = p([]), v = p(), f = p(false), { maxHeight: G } = te({ mainBox: ".product-detail", extraBox: [".el-drawer__header", ".header-div"], wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, v), V = p([["netWeight", ["to-fixed", h.COM_WT__KG]], ["totalNetWeight", ["to-fixed", h.COM_WT__KG]], ["grossWeight", ["to-fixed", h.COM_WT__KG]], ["totalGrossWeight", ["to-fixed", h.COM_WT__KG]], ["createTime", "parse-time"]]);
  function j(i) {
    return oe(i, { props: ["quantity", "totalNetWeight", "totalGrossWeight"] });
  }
  async function N() {
    var r;
    let i = [];
    f.value = true;
    try {
      const { content: c = [], totalElements: b } = await Y({ projectId: (r = l.detailQuery) == null ? void 0 : r.projectId, workshopId: l.workshopId, productType: l.productType, ...w, ...g.value, type: x[l.showType].V });
      i = c, z(b);
    } catch (c) {
      console.log("明细", c);
    } finally {
      T.value = i, f.value = false;
    }
  }
  return (i, r) => {
    const c = Q, b = y("print-table"), a = J, k = y("table-cell-tag"), E = y("common-table"), P = $, K = y("common-drawer"), q = X;
    return m(), u(K, { ref_key: "drawerRef", ref: v, title: e.showType === "INBOUND" ? "入库明细" : e.showType === "OUTBOUND" ? "出库明细" : e.showType === "STOCK" ? "期末库存明细" : e.showType === "BEGINNING" ? "期初库存明细" : e.showType === "PACKAGE" ? "打包(未装车)明细" : "清单明细", "close-on-click-modal": false, modelValue: n(d), "onUpdate:modelValue": r[0] || (r[0] = (o) => F(d) ? d.value = o : null), direction: "rtl", "before-close": n(B), "custom-class": "product-detail", size: "80%" }, { titleAfter: s(() => [t(c, { size: "large" }, { default: s(() => [M(C(`项目：${n(ae)(e.detailInfo.project)}`), 1)]), _: 1 })]), titleRight: s(() => {
      var o;
      return [O("div", { class: "header-div", style: H(e.showType === "INBOUND" || e.showType === "OUTBOUND" ? "display: flex; justify-content: space-between" : "") }, [t(b, { "api-key": e.showType === "INBOUND" ? "mesInboundInventoryDetail" : e.showType === "OUTBOUND" ? "mesOutboundInventoryDetail" : e.showType === "STOCK" ? "mesEndInventoryDetail" : e.showType === "PACKAGE" ? "mesPackageInventoryDetail" : "mesBeginningInventoryDetail", params: { projectId: (o = l.detailQuery) == null ? void 0 : o.projectId, workshopId: l.workshopId, productType: l.productType, ...g.value, type: n(x)[l.showType].V }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["api-key", "params"])], 4)];
    }), content: s(() => [L((m(), u(E, { data: T.value, "data-format": V.value, "show-summary": "", "summary-method": j, "max-height": n(G) - 100 }, { default: s(() => [t(a, { label: "序号", type: "index", align: "center", width: "60" }), t(a, { key: "monomer.name", prop: "monomer.name", label: "单体", align: "center", "show-overflow-tooltip": true }, { default: s(({ row: o }) => {
      var I;
      return [o.boolAllPartSendDirectly ? (m(), u(k, { key: 0, name: "檩条直发", color: "#f56c6c" })) : (m(), u(k, { key: 1, show: !!o.typeName, name: o.typeName, color: o.typeName === "构件" ? "#67C23A" : "#409EFF" }, null, 8, ["show", "name", "color"])), O("span", null, C(o.monomer ? (I = o.monomer) == null ? void 0 : I.name : "-"), 1)];
    }), _: 1 }), t(a, { key: "area.name", prop: "area.name", label: "区域", align: "center", "show-overflow-tooltip": true }), t(a, { key: "name", prop: "name", label: "构件名称", align: "center", "show-overflow-tooltip": true }), t(a, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": true }), t(a, { key: "specification", prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": true }), t(a, { key: "length", prop: "length", label: "长度(mm)", align: "center", "show-overflow-tooltip": true }), t(a, { key: "material", prop: "material", label: "材质", align: "center", "show-overflow-tooltip": true, width: "80px" }), t(a, { key: "quantity", prop: "quantity", label: "数量", align: "center", "show-overflow-tooltip": true, width: "60px" }), t(a, { key: "netWeight", prop: "netWeight", label: "单净重（kg）", align: "center", "show-overflow-tooltip": true }), t(a, { key: "grossWeight", prop: "grossWeight", label: "单毛重（kg）", align: "center", "show-overflow-tooltip": true }), t(a, { key: "totalNetWeight", prop: "totalNetWeight", label: "总净重（kg）", align: "center", "show-overflow-tooltip": true }), t(a, { key: "totalGrossWeight", prop: "totalGrossWeight", label: "总毛重（kg）", align: "center", "show-overflow-tooltip": true }), e.showType === "INBOUND" || e.showType === "OUTBOUND" ? (m(), u(a, { key: "createTime", prop: "createTime", label: e.showType === "INBOUND" ? "入库日期" : "出库日期", align: "center", "show-overflow-tooltip": true }, null, 8, ["label"])) : R("", true)]), _: 1 }, 8, ["data", "data-format", "max-height"])), [[q, f.value]]), t(P, { total: n(S), "current-page": n(w).pageNumber, "page-size": n(w).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: n(W), onCurrentChange: n(U) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} };
export {
  ie as default
};
