import { _ as G, m as H, i as r, kf as X, Bk as h, bg as d, cM as $, cl as Y, cO as Z, am as ee, jl as te, Bl as ae, gp as ne, d5 as se } from "../../../../../shared/runtime.js";
import { d as ie } from "../../../../../modules/mes-receipt-review-377f871a.js";
import { ref as m } from "vue";
import { computed as T } from "vue";
import { watch as x } from "vue";
import { onMounted as le } from "vue";
import { ElLoading as U } from "element-plus";
import { ElMessage as P } from "element-plus";
import { resolveComponent as re } from "vue";
import { openBlock as w } from "vue";
import { createElementBlock as A } from "vue";
import { createVNode as f } from "vue";
import { withCtx as I } from "vue";
import { unref as o } from "vue";
import { ElButton as oe } from "element-plus";
import { Fragment as ue } from "vue";
import { createBlock as L } from "vue";
import { createCommentVNode as ce } from "vue";
import { ElButtonGroup as pe } from "element-plus";
const de = { __name: "index", props: { apiKey: { type: [Array, String], default: void 0 }, currentKey: { type: String, default: void 0 }, beforePrint: { type: Function, default: void 0 }, size: { type: String, default: "default" }, disabled: { type: Boolean, default: false }, params: { type: null, default: void 0 }, btnType: { type: String, default: "warning" }, isPrint: { type: Boolean, default: false } }, emits: ["update:currentKey", "change", "success", "download-success", "print-success"], setup(D, { emit: F }) {
  const u = F, a = D, l = m({}), c = m(void 0), E = m(void 0), p = m(false), S = m(false), { user: K } = H("user"), y = T(() => K.value && K.value.id), _ = T(() => {
    let e = "";
    if (r(a.apiKey)) if (a.apiKey instanceof Array) if (a.apiKey.length === 1) e = a.apiKey[0];
    else {
      e = a.apiKey;
      const t = X(e.map((n) => h[n] || n));
      return t.length > 1 ? t : t[0];
    }
    else e = a.apiKey;
    return h[e] || e;
  }), j = T(() => _.value instanceof Array), v = T(() => {
    if (r(l.value) && r(l.value.type)) {
      const e = l.value.type;
      if (a.apiKey instanceof Array) {
        for (const t of a.apiKey) if (t === e || h[t] === e) return t;
      } else return a.apiKey;
    }
  });
  x(() => a.isPrint, (e) => {
    e && b(d.QUEUE.V);
  }), x(() => a.apiKey, (e) => {
    let t = "";
    r(e) && (t = e instanceof Array ? e[0] : e), E.value = M(t);
  }, { immediate: true }), x(() => v.value, (e) => {
    q(e);
  }), le(() => {
    S.value = true;
  });
  function q(e) {
    u("update:currentKey", e), u("change", e);
  }
  function N(e) {
    r(e) ? l.value = JSON.parse(typeof e == "object" ? JSON.stringify(e) : e) : l.value = "";
  }
  function M(e) {
    let t = "";
    return r(y.value) && r(e) && (t = ($.get(`printTable_${y.value}`) || {})[e]), t;
  }
  function B(e, t) {
    if (r(y.value) && r(e) && r(t)) {
      const n = $.get(`printTable_${y.value}`) || {};
      n[e] = t, $.set(`printTable_${y.value}`, n);
    }
  }
  async function J() {
    if (typeof a.beforePrint != "function" || a.beforePrint() !== false) {
      B(v.value, c.value);
      const e = U.service({ lock: true, text: "准备导出", spinner: "el-icon-loading", fullscreen: true });
      try {
        let t = a.params;
        a.params instanceof Array || (t = [a.params]);
        for (const n of t) {
          const s = n;
          e.text = `正在加载数据：${l.value.name}`;
          const { header: i, footer: g, table: C, qrCode: z } = await V(n) || {};
          if (e.text = `正在导出：${l.value.name}`, await se({ header: i, footer: g, table: C, qrCode: z, config: l.value })) u("success"), u("download-success", s);
          else throw new Error("导出失败");
        }
      } catch (t) {
        P.error(`${t}`), console.log("导出", t);
      } finally {
        e.text = "导出结束", e.close();
      }
    }
  }
  async function b(e) {
    if (typeof a.beforePrint != "function" || a.beforePrint() !== false) {
      B(v.value, c.value);
      const t = U.service({ lock: true, text: "准备打印", spinner: "el-icon-loading", fullscreen: true });
      try {
        let n = a.params;
        a.params instanceof Array || (n = [a.params]), e === d.PREVIEW.V && (n = [n[0]]);
        for (const s of n) {
          const i = s;
          t.setText(`正在加载数据：${l.value.name}`);
          const { header: g, footer: C, table: z, qrCode: O } = await V(s) || {};
          t.setText(`正在打印：${l.value.name}`);
          const k = await Y({ printMode: e, header: g, footer: C, table: z, qrCode: O, config: l.value });
          if (typeof k == "object") {
            const { type: R, message: W } = k;
            return P({ type: R, message: W });
          }
          if (k) e !== d.PREVIEW.V && (u("success"), u("print-success", i));
          else throw new Error("打印失败");
        }
      } catch (n) {
        P.error(`${n}`), console.log("打印", n);
      } finally {
        t.text = "打印结束", t.close();
      }
    }
  }
  async function V(e) {
    var n, s;
    if (v.value) try {
      const i = await ie(e) || {};
      return await Q(i), { header: { createTime: i.createTime, reviewTime: i.reviewTime, reviewerName: i.reviewerName, taskOrderNumber: i.taskOrderNumber, applicantSN: i.applicantSN, schedulerName: (s = (n = i.list[0]) == null ? void 0 : n.recipient) == null ? void 0 : s.name, printDate: (/* @__PURE__ */ new Date()).getTime() }, qrCode: {}, table: i.list || [], footer: {} };
    } catch (i) {
      throw console.error(i), new Error("加载打印数据失败");
    }
  }
  async function Q(e) {
    return await Z(e.list), e.list.forEach((t) => {
      t.basicClass === ee.STEEL_PLATE.V && (t.accountingPrecision = 3);
    }), e.list = await te(e.list, { toSmallest: false, toNum: false }), e;
  }
  return (e, t) => {
    const n = re("common-button");
    return w(), A("span", null, [f(o(pe), { class: "button-group" }, { default: I(() => [f(o(oe), { class: "input-button", size: a.size, type: a.btnType, plain: "" }, { default: I(() => [S.value ? (w(), A(ue, { key: 0 }, [j.value ? (w(), L(o(ae), { key: 0, value: c.value, "onUpdate:value": t[0] || (t[0] = (s) => c.value = s), "table-types": _.value, size: a.size, "cache-template-id": E.value, initial: "", filterable: "", default: "", onChange: N, onOnload: t[1] || (t[1] = (s) => p.value = true) }, null, 8, ["value", "table-types", "size", "cache-template-id"])) : (w(), L(o(ne), { key: 1, value: c.value, "onUpdate:value": t[2] || (t[2] = (s) => c.value = s), "table-type": _.value, size: a.size, "cache-template-id": E.value, default: "", filterable: "", onChange: N, onOnload: t[3] || (t[3] = (s) => p.value = true) }, null, 8, ["value", "table-type", "size", "cache-template-id"]))], 64)) : ce("", true)]), _: 1 }, 8, ["size", "type"]), f(n, { size: a.size, disabled: !p.value || a.disabled, icon: "el-icon-view", type: a.btnType, plain: "", onClick: t[4] || (t[4] = (s) => b(o(d).PREVIEW.V)) }, null, 8, ["size", "disabled", "type"]), f(n, { size: a.size, disabled: !p.value || a.disabled, icon: "el-icon-printer", type: a.btnType, plain: "", onClick: t[5] || (t[5] = (s) => b(o(d).QUEUE.V)) }, null, 8, ["size", "disabled", "type"]), f(n, { disabled: !p.value || a.disabled, size: a.size, type: a.btnType, icon: "el-icon-document-copy", plain: "", onClick: t[6] || (t[6] = (s) => b(o(d).CUSTOM_QUEUE.V)) }, null, 8, ["disabled", "size", "type"]), f(n, { size: a.size, disabled: !p.value || a.disabled, icon: "el-icon-download", type: a.btnType, plain: "", onClick: J }, null, 8, ["size", "disabled", "type"])]), _: 1 })]);
  };
} }, ve = G(de, [["__scopeId", "data-v-01ac734d"]]);
export {
  ve as default
};
