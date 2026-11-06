import { ref as B } from "vue";
import { resolveComponent as c } from "vue";
import { openBlock as f } from "vue";
import { createBlock as h } from "vue";
import { withCtx as u } from "vue";
import { unref as o } from "vue";
import { createCommentVNode as W } from "vue";
import { createVNode as t } from "vue";
import { isRef as D } from "vue";
import { ElTableColumn as I } from "element-plus";
import { ElPagination as R } from "element-plus";
import { l as b, u as S, J as U, o as V, G as H } from "../../../../../shared/runtime.js";
function O(a) {
  return b({ module: "crm", url: "data/center/business/custom", method: "get", params: a });
}
function E(a) {
  return b({ module: "crm", url: "data/center/get/info/by/informant/user/custom", method: "get", params: a });
}
const q = { get: O }, T = { __name: "detail", props: { visible: { type: Boolean, default: false }, detailData: { type: Object, default: () => {
} }, permission: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(a, { emit: w }) {
  const y = w, p = B([]), d = a, { visible: l, handleClose: _ } = S({ emit: y, props: d, field: "visible", showHook: g }), { handleSizeChange: v, handleCurrentChange: N, total: k, setTotalPage: x, queryPage: i } = U({ fetchHook: g }), { maxHeight: C } = V({ mainBox: ".detail-drawer", extraBox: [".el-drawer__header", ".head-container"], wrapperBox: [".el-drawer__body"], paginate: true }, l);
  async function g() {
    var r;
    let m = [];
    try {
      const { content: n = [], totalElements: e } = await E({ informantUserId: (r = d.detailData) == null ? void 0 : r.informantUserId, ...i });
      x(e), m = n;
    } catch (n) {
      console.log("获取详情失败", n);
    } finally {
      p.value = m;
    }
  }
  return (m, r) => {
    const n = c("print-table"), e = I, z = c("common-table"), P = R, j = c("common-drawer");
    return f(), h(j, { ref: "drawerRef", title: "商务汇总详情", "close-on-click-modal": false, "custom-class": "detail-drawer", modelValue: o(l), "onUpdate:modelValue": r[0] || (r[0] = (s) => D(l) ? l.value = s : null), direction: "rtl", "before-close": o(_), size: "60%" }, { titleRight: u(() => {
      var s;
      return [o(H)(a.permission.detailPrint) ? (f(), h(n, { key: 0, "api-key": "businessSummaryDetailReport", params: { informantUserId: (s = a.detailData) == null ? void 0 : s.informantUserId, ...o(i) }, size: "default", type: "warning", class: "filter-item" }, null, 8, ["params"])) : W("", true)];
    }), content: u(() => [t(z, { ref: "tableRef", "max-height": o(C), data: p.value, style: { width: "100%" } }, { default: u(() => [t(e, { prop: "index", label: "序号", align: "center", width: "60", type: "index" }), t(e, { key: "departmentName", prop: "departmentName", "show-overflow-tooltip": true, label: "销售部", align: "center" }), t(e, { align: "center", key: "informantUserName", prop: "informantUserName", "show-overflow-tooltip": true, label: "销售员" }), t(e, { key: "projectName", prop: "projectName", align: "center", "show-overflow-tooltip": true, label: "工程名称" }), t(e, { key: "projectInformationWarehousingNum", prop: "projectInformationWarehousingNum", "show-overflow-tooltip": true, align: "center", label: "项目信息登记数量" }), t(e, { key: "governmentWarehousingNum", prop: "governmentWarehousingNum", align: "center", "show-overflow-tooltip": true, label: "是否政府备案" }), t(e, { key: "biddingPlatformWarehousingNum", prop: "biddingPlatformWarehousingNum", align: "center", "show-overflow-tooltip": true, label: "是否平台注册" }), t(e, { key: "supplierWarehousingNum", prop: "supplierWarehousingNum", align: "center", "show-overflow-tooltip": true, label: "是否业主供应商入库" }), t(e, { key: "applyForBidRecordNum", prop: "applyForBidRecordNum", align: "center", "show-overflow-tooltip": true, label: "项目投标报名数量" })]), _: 1 }, 8, ["max-height", "data"]), t(P, { total: o(k), "current-page": o(i).pageNumber, "page-size": o(i).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: o(v), onCurrentChange: o(N) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, A = Object.freeze(Object.defineProperty({ __proto__: null, default: T }, Symbol.toStringTag, { value: "Module" }));
export {
  T as _,
  q as c,
  A as d
};
