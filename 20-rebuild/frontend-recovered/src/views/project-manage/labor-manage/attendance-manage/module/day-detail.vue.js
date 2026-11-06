import { ref as y } from "vue";
import { watch as E } from "vue";
import { resolveComponent as w } from "vue";
import { openBlock as g } from "vue";
import { createBlock as _ } from "vue";
import { withCtx as n } from "vue";
import { createVNode as a } from "vue";
import { createTextVNode as D } from "vue";
import { toDisplayString as s } from "vue";
import { unref as o } from "vue";
import O from "moment";
import { createCommentVNode as W } from "vue";
import { createElementVNode as i } from "vue";
import { createElementBlock as L } from "vue";
import { Fragment as P } from "vue";
import { renderList as U } from "vue";
import { isRef as F } from "vue";
import { ElTag as R } from "element-plus";
import { ElTableColumn as M } from "element-plus";
import { ElImage as q } from "element-plus";
import { ElPagination as A } from "element-plus";
import { a as G, d as J } from "../../../../../modules/attendance-manage-750617cc.js";
import { _ as Y, u as $, J as K, o as Q, G as X, L as Z } from "../../../../../shared/runtime.js";
const ee = { class: "imgs-box" }, te = { __name: "day-detail", props: { visible: { type: Boolean, default: false }, projectId: { type: [Number, String] }, supplierId: { type: [Number, String] }, currentDay: { type: String }, permission: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(m, { emit: C }) {
  const d = y([]), x = C, p = m, T = y([["attendanceDate", ["parse-time", "{y}-{m}-{d}"]], ["morningWorkingTime", ["parse-time", "{h}:{i}"]], ["morningClosingTime", ["parse-time", "{h}:{i}"]], ["afternoonWorkingTime", ["parse-time", "{h}:{i}"]], ["afternoonClosingTime", ["parse-time", "{h}:{i}"]], ["overtimeWorkingTime", ["parse-time", "{h}:{i}"]], ["overtimeClosingTime", ["parse-time", "{h}:{i}"]]]), { visible: c, handleClose: k } = $({ emit: x, props: p, field: "visible" }), { handleSizeChange: I, handleCurrentChange: S, total: H, setTotalPage: N, queryPage: f } = K({ fetchHook: b });
  E(() => p.visible, (u) => {
    u && b();
  }, { immediate: true });
  const { maxHeight: V } = Q({ extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, navbar: false }, c);
  async function b() {
    var l;
    let u = [];
    try {
      const { content: r = [], totalElements: t } = await G({ monthDate: new Date(p.currentDay).getTime(), projectId: p.projectId, supplierId: p.supplierId, isSummaryDetail: true, ...f });
      u = r, N(t);
    } catch (r) {
      console.log(r, "获取日打卡明细失败");
    } finally {
      d.value = u, (l = d.value) == null || l.forEach((r) => {
        var t;
        r.imgUrls = r.attachmentDTOList && ((t = r.attachmentDTOList) == null ? void 0 : t.map((h) => h.imageUrl));
      });
    }
  }
  return (u, l) => {
    const r = R, t = M, h = q, z = w("common-table"), j = A, B = w("common-dialog");
    return g(), _(B, { title: "打卡明细", modelValue: o(c), "onUpdate:modelValue": l[0] || (l[0] = (e) => F(c) ? c.value = e : null), width: "1200px", "before-close": o(k) }, { titleAfter: n(() => [a(r, { effect: "plain" }, { default: n(() => [D(s(m.currentDay), 1)]), _: 1 })]), titleRight: n(() => {
      var e;
      return [o(X)(m.permission.export) ? (g(), _(Z, { key: 0, params: { monthDate: o(O)(m.currentDay).startOf("day").valueOf(), projectId: m.projectId, supplierId: m.supplierId, isSummaryDetail: true }, fn: o(J), disabled: !((e = d.value) != null && e.length) }, { default: n(() => l[1] || (l[1] = [D(" 下载考勤明细 ")])), _: 1, __: [1] }, 8, ["params", "fn", "disabled"])) : W("", true)];
    }), default: n(() => [a(z, { data: d.value, "data-format": T.value, "max-height": o(V), style: { width: "100%" } }, { default: n(() => [a(t, { label: "序号", type: "index", align: "center", width: "60" }), a(t, { prop: "attendanceDate", "show-overflow-tooltip": true, label: "时间", align: "center", width: "110" }), a(t, { prop: "userName", "show-overflow-tooltip": true, label: "姓名", align: "center" }), a(t, { prop: "supplierName", "show-overflow-tooltip": true, label: "分包单位", align: "center" }), a(t, { "show-overflow-tooltip": true, label: "上午", align: "center" }, { default: n(({ row: e }) => [i("span", null, s(e.morningWorkingTime), 1), l[2] || (l[2] = i("span", null, " ~ ", -1)), i("span", null, s(e.morningClosingTime), 1)]), _: 1 }), a(t, { "show-overflow-tooltip": true, label: "下午", align: "center" }, { default: n(({ row: e }) => [i("span", null, s(e.afternoonWorkingTime), 1), l[3] || (l[3] = i("span", null, " ~ ", -1)), i("span", null, s(e.afternoonClosingTime), 1)]), _: 1 }), a(t, { "show-overflow-tooltip": true, label: "加班", align: "center" }, { default: n(({ row: e }) => [i("span", null, s(e.overtimeWorkingTime), 1), l[4] || (l[4] = i("span", null, " ~ ", -1)), i("span", null, s(e.overtimeClosingTime), 1)]), _: 1 }), a(t, { prop: "workHours", "show-overflow-tooltip": true, label: "标准工作时长（h）", align: "center" }), a(t, { prop: "actualHours", "show-overflow-tooltip": true, label: "实际时长（h）", align: "center" }), a(t, { prop: "overHours", "show-overflow-tooltip": true, label: "加班时长（h）", align: "center" }), a(t, { prop: "attachment", "show-overflow-tooltip": true, label: "打卡图片", align: "left" }, { default: n(({ row: e }) => [i("div", ee, [(g(true), L(P, null, U(e == null ? void 0 : e.attachmentDTOList, (v) => (g(), _(h, { "preview-src-list": e == null ? void 0 : e.imgUrls, "initial-index": 1, "preview-teleported": "", key: v.id, src: v.tinyImageUrl, lazy: "" }, null, 8, ["preview-src-list", "src"]))), 128))])]), _: 1 })]), _: 1 }, 8, ["data", "data-format", "max-height"]), a(j, { total: o(H), "current-page": o(f).pageNumber, "page-size": o(f).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: o(I), onCurrentChange: o(S) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["modelValue", "before-close"]);
  };
} }, ne = Y(te, [["__scopeId", "data-v-bd435270"]]);
export {
  ne as default
};
