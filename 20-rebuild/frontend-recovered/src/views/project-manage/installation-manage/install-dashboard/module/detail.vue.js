import { watch as S } from "vue";
import { ref as s } from "vue";
import { resolveComponent as f } from "vue";
import { openBlock as h } from "vue";
import { createBlock as w } from "vue";
import { withCtx as b } from "vue";
import { withDirectives as j } from "vue";
import { unref as a } from "vue";
import { createVNode as t } from "vue";
import { isRef as P } from "vue";
import { ElTableColumn as I } from "element-plus";
import { ElPagination as q } from "element-plus";
import { vLoading as E } from "element-plus";
import { l as _, u as F, J as M, o as O } from "../../../../../shared/runtime.js";
function $(o) {
  return _({ module: "project", url: "install-report/install-boardV2", method: "get", params: o });
}
function U(o) {
  return _({ module: "project", url: "install-report/install-board/details", method: "get", params: o });
}
const L = { __name: "detail", props: { modelValue: { type: Boolean, require: true }, detailData: { type: Object, default: () => {
} } }, emits: ["update:modelValue"], setup(o, { emit: y }) {
  const v = y, c = o, { visible: i, handleClose: x } = F({ emit: v, props: c }), { handleSizeChange: C, handleCurrentChange: k, total: z, setTotalPage: N, queryPage: p } = M({ fetchHook: g });
  S(i, (l) => {
    l && g();
  }, { immediate: true });
  const d = s([]), u = s(), T = s(false), V = s([["createTime", "parse-time"]]), { maxHeight: D } = O({ mainBox: ".summary-detail", extraBox: ".el-drawer__header", wrapperBox: ".el-drawer__body", paginate: true, minHeight: 300, navbar: false, clientHRepMainH: true }, u);
  async function g() {
    var r, e;
    let l = [];
    try {
      const { content: n = [], totalElements: m } = await U({ productId: (r = c.detailData) == null ? void 0 : r.productId, productType: (e = c.detailData) == null ? void 0 : e.productType, ...p });
      l = n, N(m);
    } catch (n) {
      console.log(n, "获取安装记录列表失败");
    } finally {
      d.value = l;
    }
  }
  return (l, r) => {
    const e = I, n = f("common-table"), m = q, B = f("common-drawer"), H = E;
    return h(), w(B, { ref_key: "drawerRef", ref: u, title: `${o.detailData.serialNumber} 安装记录`, "close-on-click-modal": false, modelValue: a(i), "onUpdate:modelValue": r[0] || (r[0] = (R) => P(i) ? i.value = R : null), direction: "rtl", "before-close": a(x), "custom-class": "summary-detail", size: "50%" }, { content: b(() => [j((h(), w(n, { data: d.value, "max-height": a(D), dataFormat: V.value }, { default: b(() => [t(e, { label: "序号", type: "index", align: "center", width: "60", "show-overflow-tooltip": "" }), t(e, { key: "name", prop: "name", label: "名称", align: "center", "show-overflow-tooltip": "" }), t(e, { key: "serialNumber", prop: "serialNumber", label: "编号", align: "center", "show-overflow-tooltip": "" }), t(e, { key: "specification", prop: "specification", label: "规格", align: "center", "show-overflow-tooltip": "", "min-width": "120" }), t(e, { key: "reportQuantity", prop: "reportQuantity", label: "数量", align: "center", "show-overflow-tooltip": "" }), t(e, { key: "supplierName", prop: "supplierName", label: "安装单位", align: "center", "show-overflow-tooltip": "", "min-width": "120" }), t(e, { key: "reportUserName", prop: "reportUserName", label: "填报人", align: "center", "show-overflow-tooltip": "" }), t(e, { key: "createTime", prop: "createTime", label: "安装日期", align: "center", "show-overflow-tooltip": "", "min-width": "120" })]), _: 1 }, 8, ["data", "max-height", "dataFormat"])), [[H, T.value]]), t(m, { total: a(z), "current-page": a(p).pageNumber, "page-size": a(p).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: a(C), onCurrentChange: a(k) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} }, A = Object.freeze(Object.defineProperty({ __proto__: null, default: L }, Symbol.toStringTag, { value: "Module" }));
export {
  L as _,
  A as d,
  $ as i
};
