import { ref as w } from "vue";
import { watch as O } from "vue";
import { resolveComponent as S } from "vue";
import { openBlock as n } from "vue";
import { createBlock as r } from "vue";
import { withCtx as s } from "vue";
import { createVNode as u } from "vue";
import { createTextVNode as x } from "vue";
import { toDisplayString as c } from "vue";
import { unref as i } from "vue";
import { createCommentVNode as o } from "vue";
import { createElementVNode as d } from "vue";
import { createElementBlock as v } from "vue";
import { isRef as R } from "vue";
import { ElTag as U } from "element-plus";
import { ElTableColumn as j } from "element-plus";
import { ElPagination as F } from "element-plus";
import { a as M, d as q } from "../../../../../../modules/attendance-report-ce8c4447.js";
import { u as A, J as G, o as J, G as $, L as K } from "../../../../../../shared/runtime.js";
const Q = { key: 0 }, X = { key: 0 }, Y = { key: 0 }, ae = { __name: "day-detail", props: { visible: { type: Boolean, default: false }, supplierId: { type: [Number, String] }, currentDay: { type: String }, permission: { type: Object, default: () => {
} } }, emits: ["update:visible"], setup(a, { emit: _ }) {
  const f = w([]), H = _, g = a, W = w([["attendanceDate", ["parse-time", "{y}-{m}-{d}"]], ["morningWorkingTime", ["parse-time", "{h}:{i}"]], ["morningClosingTime", ["parse-time", "{h}:{i}"]], ["afternoonWorkingTime", ["parse-time", "{h}:{i}"]], ["afternoonClosingTime", ["parse-time", "{h}:{i}"]], ["overtimeWorkingTime", ["parse-time", "{h}:{i}"]], ["overtimeClosingTime", ["parse-time", "{h}:{i}"]]]), { visible: h, handleClose: V } = A({ emit: H, props: g, field: "visible" }), { handleSizeChange: z, handleCurrentChange: B, total: N, setTotalPage: E, queryPage: y } = G({ fetchHook: k });
  O(() => g.visible, (p) => {
    p && k();
  }, { immediate: true });
  const { maxHeight: I } = J({ extraBox: [".el-dialog__header"], wrapperBox: [".el-dialog__body"], clientHRepMainH: true, minHeight: 300, navbar: false }, h);
  async function k() {
    var m;
    let p = [];
    try {
      const { content: l = [], totalElements: t } = await M({ dayDate: new Date(g.currentDay.data).getTime(), supplierId: g.supplierId, isStand: g.currentDay.isStand, ...y });
      p = l, E(t);
    } catch (l) {
      console.log(l, "获取日打卡明细失败");
    } finally {
      f.value = p, (m = f.value) == null || m.forEach((l) => {
        var t;
        l.imgUrls = l.attachmentDTOList && ((t = l.attachmentDTOList) == null ? void 0 : t.map((b) => b.imageUrl));
      });
    }
  }
  return (p, m) => {
    var D;
    const l = U, t = j, b = S("common-table"), P = F, L = S("common-dialog");
    return n(), r(L, { title: (D = a.currentDay) != null && D.isStand ? "常规考勤打卡明细" : "加班考勤打卡明细", modelValue: i(h), "onUpdate:modelValue": m[0] || (m[0] = (e) => R(h) ? h.value = e : null), width: "1200px", "before-close": i(V) }, { titleAfter: s(() => [u(l, { effect: "plain" }, { default: s(() => {
      var e;
      return [x(c((e = a.currentDay) == null ? void 0 : e.data), 1)];
    }), _: 1 })]), titleRight: s(() => {
      var e, T, C;
      return [i($)([...a.permission.export]) ? (n(), r(K, { key: 0, params: { dayDate: new Date((e = a.currentDay) == null ? void 0 : e.data).getTime(), supplierId: a.supplierId, isStand: (T = a.currentDay) == null ? void 0 : T.isStand }, fn: i(q), disabled: !((C = f.value) != null && C.length) }, { default: s(() => m[1] || (m[1] = [x(" 下载考勤明细 ")])), _: 1, __: [1] }, 8, ["params", "fn", "disabled"])) : o("", true)];
    }), default: s(() => [u(b, { data: f.value, "data-format": W.value, "max-height": i(I), style: { width: "100%" } }, { default: s(() => [u(t, { label: "序号", type: "index", align: "center", width: "60" }), u(t, { prop: "attendanceDate", "show-overflow-tooltip": true, label: "时间", align: "center", width: "110" }), u(t, { prop: "name", "show-overflow-tooltip": true, label: "姓名", align: "center" }), u(t, { prop: "supplierName", "show-overflow-tooltip": true, label: "分包单位", align: "center" }), a.currentDay.isStand ? (n(), r(t, { key: 0, "show-overflow-tooltip": true, label: "上午", align: "center" }, { default: s(({ row: e }) => [d("span", null, c(e.morningWorkingTime), 1), e.morningWorkingTime && e.morningClosingTime ? (n(), v("span", Q, " ~ ")) : o("", true), d("span", null, c(e.morningClosingTime), 1)]), _: 1 })) : o("", true), a.currentDay.isStand ? (n(), r(t, { key: 1, "show-overflow-tooltip": true, label: "下午", align: "center" }, { default: s(({ row: e }) => [d("span", null, c(e.afternoonWorkingTime), 1), e.afternoonWorkingTime && e.afternoonClosingTime ? (n(), v("span", X, " ~ ")) : o("", true), d("span", null, c(e.afternoonClosingTime), 1)]), _: 1 })) : o("", true), a.currentDay.isStand ? o("", true) : (n(), r(t, { key: 2, "show-overflow-tooltip": true, label: "加班", align: "center" }, { default: s(({ row: e }) => [d("span", null, c(e.overtimeWorkingTime), 1), e.overtimeWorkingTime && e.overtimeClosingTime ? (n(), v("span", Y, " ~ ")) : o("", true), d("span", null, c(e.overtimeClosingTime), 1)]), _: 1 })), a.currentDay.isStand ? (n(), r(t, { key: 3, prop: "workHours", "show-overflow-tooltip": true, label: "标准工作时长（h）", align: "center" })) : o("", true), a.currentDay.isStand ? (n(), r(t, { key: 4, prop: "actualHours", "show-overflow-tooltip": true, label: "实际时长（h）", align: "center" })) : o("", true), a.currentDay.isStand ? o("", true) : (n(), r(t, { key: 5, prop: "overWorkHours", "show-overflow-tooltip": true, label: "加班时长（h）", align: "center" })), a.currentDay.isStand ? o("", true) : (n(), r(t, { key: 6, prop: "overHours", "show-overflow-tooltip": true, label: " 加班实际时长（h）", align: "center" }))]), _: 1 }, 8, ["data", "data-format", "max-height"]), u(P, { total: i(N), "current-page": i(y).pageNumber, "page-size": i(y).pageSize, style: { "margin-top": "8px" }, layout: "total, prev, pager, next, sizes", onSizeChange: i(z), onCurrentChange: i(B) }, null, 8, ["total", "current-page", "page-size", "onSizeChange", "onCurrentChange"])]), _: 1 }, 8, ["title", "modelValue", "before-close"]);
  };
} };
export {
  ae as default
};
